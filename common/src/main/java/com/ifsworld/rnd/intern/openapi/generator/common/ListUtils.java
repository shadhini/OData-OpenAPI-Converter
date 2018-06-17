package com.ifsworld.rnd.intern.openapi.generator.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListUtils {

    //this methods sorts a given set of strings in the alphabetical order ascending
    public static List<String> sortSetAlphabetically(Set<String> unsortedSet){

        List<String> list =  new ArrayList<>();
        list.addAll(unsortedSet);

        return sortListAlphabetically(list);
    }

    //this method sorts a given list of strings in the alphabetical order ascending
    public static List<String> sortListAlphabetically(List<String> list){

        for (int i = 0 ; i < list.size() ; i++){
            for (int j = 0 ; j < list.size() ; j++){
                if(list.get(i).toLowerCase().compareTo(list.get(j).toLowerCase()) < 0){
                    String temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }
}
