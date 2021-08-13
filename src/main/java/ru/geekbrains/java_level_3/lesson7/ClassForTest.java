package ru.geekbrains.java_level_3.lesson7;

public class ClassForTest {

    @Test(priority = 10)
    public static void method1() {
        System.out.println("@Test(priority = 10) Method1 executing");
    }

    @AfterSuite
    public void method2() {
        System.out.println("@AfterSuite non-static Method2 executing");
    }

    @Test(priority = 1)
    public static void method3() {
        System.out.println("@Test(priority = 1) Method3 executing");
    }

    @Test
    public void method4() {
        System.out.println("@Test non-static Method4 executing");
    }

    public static void method5() {
        System.out.println("Method5 executing");
    }

    @Test(priority = 6)
    public static void method6() {
        System.out.println("@Test(priority = 6) Method6 executing");
    }

    @BeforeSuite
    public static void method7() {
        System.out.println("@BeforeSuite Method7 executing");
    }

    @Test(priority = 3)
    public static void method8() {
        System.out.println("@Test(priority = 3) Method8 executing");
    }
}
