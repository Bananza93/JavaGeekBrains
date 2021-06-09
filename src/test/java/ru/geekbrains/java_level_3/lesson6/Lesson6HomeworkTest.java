package ru.geekbrains.java_level_3.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Lesson6HomeworkTest {
    private Lesson6Homework instance;

    @BeforeEach
    void beforeEach() {
        System.out.println("Start");
        instance = new Lesson6Homework();
    }

    @AfterEach
    void afterEach() {
        System.out.println("Complete");
    }

    @ParameterizedTest
    @MethodSource("lastAfterLastFourFillForArrayEqualsAssert")
    void lastAfterLastFourArrayEquals(int[] in, int[] out) {
        Assertions.assertArrayEquals(out, instance.lastAfterLastFour(in));
    }

    private static Stream<Arguments> lastAfterLastFourFillForArrayEqualsAssert() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {1,2,4,4,2,3,4,1,7}, new int[] {1,7}));
        list.add(Arguments.arguments(new int[] {1,2,4,4,2,3,4,1,4}, new int[] {}));
        list.add(Arguments.arguments(new int[] {4,2,8,1,2,3,5,1,3}, new int[] {2,8,1,2,3,5,1,3}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("lastAfterLastFourFillForThrowAssert")
    void lastAfterLastFourThrow(int[] in, Class<Throwable> out) {
        Assertions.assertThrows(out, () -> instance.lastAfterLastFour(in));
    }

    private static Stream<Arguments> lastAfterLastFourFillForThrowAssert() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {}, RuntimeException.class));
        list.add(Arguments.arguments(new int[] {1,2,3,5,2,3,0,1,7}, RuntimeException.class));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("isOneAndFourOnlyFillForTrueAssert")
    void isOneAndFourOnlyTrue(int[] in) {
        Assertions.assertTrue(instance.isOneAndFourOnly(in));
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    private static Stream<Arguments> isOneAndFourOnlyFillForTrueAssert() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {1,4,4,4,1}));
        list.add(Arguments.arguments(new int[] {4,1,1,1,4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("isOneAndFourOnlyFillForFalseAssert")
    void isOneAndFourOnlyFalse(int[] in) {
        Assertions.assertFalse(instance.isOneAndFourOnly(in));
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    private static Stream<Arguments> isOneAndFourOnlyFillForFalseAssert() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {1,1,1,1,1}));
        list.add(Arguments.arguments(new int[] {4,4,4,4,4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("isOneAndFourOnlyFillForThrowsAssert")
    void isOneAndFourOnlyThrows(int[] in, Class<Throwable> out) {
        Assertions.assertThrows(out, () -> instance.isOneAndFourOnly(in));
    }

    private static Stream<Arguments> isOneAndFourOnlyFillForThrowsAssert() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {3,1,3,4,4}, RuntimeException.class));
        list.add(Arguments.arguments(new int[] {1,5,1,3,1}, RuntimeException.class));
        list.add(Arguments.arguments(new int[] {1,1,4,1,8}, RuntimeException.class));
        return list.stream();
    }
}