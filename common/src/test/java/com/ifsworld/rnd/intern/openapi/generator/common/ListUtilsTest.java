package com.ifsworld.rnd.intern.openapi.generator.common;

import java.util.ArrayList;
import java.util.List;

public class ListUtilsTest {

    public static void main(String[] args) {

        List<String> words =  new ArrayList<>();

        words.add("Enter");
        words.add("size");
        words.add("array");
        words.add("names");
        words.add("enter");
        words.add("array");
        words.add("help");
        words.add("compareTo");
        words.add("operator");
        words.add("easily");
        words.add("sort");
        words.add("Alphabetical");
        words.add("Order");
        words.add("Windows");

        System.out.println("Unsorted list: " + words.toString());
        System.out.println("Sorted list: " + ListUtils.sortListAlphabetically(words).toString());
    }
}
