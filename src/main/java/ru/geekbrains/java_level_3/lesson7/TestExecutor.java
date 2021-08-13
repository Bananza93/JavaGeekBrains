package ru.geekbrains.java_level_3.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TestExecutor {

    private static Class<?> testingClass;
    private static Method before;
    private static Method after;
    private static Map<Integer, ArrayList<Method>> tests;

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        start(Class.forName(className));
    }

    public static void start(Class<?> c) throws InvocationTargetException, IllegalAccessException {
        resetFields();
        initFields(c);
        smartInvoke(before);
        for (ArrayList<Method> methods : tests.values()) {
            for (Method method : methods) smartInvoke(method);
        }
        smartInvoke(after);
    }

    private static void smartInvoke(Method method) throws InvocationTargetException, IllegalAccessException {
        if (method == null) return;
        if (Modifier.isStatic(method.getModifiers())) {
            method.invoke(null);
        } else {
            try {
                method.invoke(testingClass.getConstructor().newInstance());
            } catch (NoSuchMethodException e) {
                System.out.println("WARNING! Can't invoke non-static method " + method.getName() + ". No default constructor in the class");
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initFields(Class<?> c) {
        testingClass = c;
        for (Method m : c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (before == null) before = m;
                else throw new RuntimeException("Duplicate BeforeSuite annotation for method " + m.getName());
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                if (after == null) after = m;
                else throw new RuntimeException("Duplicate AfterSuite annotation for method " + m.getName());
            } else if (m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new IllegalArgumentException("Method " + m.getName() + ": The test priority must be between 1 and 10");
                if (!tests.containsKey(priority)) tests.put(priority, new ArrayList<>());
                tests.get(priority).add(m);
            }
        }
    }

    private static void resetFields() {
        testingClass = null;
        before = null;
        after = null;
        tests = new TreeMap<>();
    }
}
