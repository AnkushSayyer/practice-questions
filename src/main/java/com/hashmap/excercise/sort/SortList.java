package com.hashmap.excercise.sort;

import java.util.*;

/**
 * Return a list with all duplicates at the end and all unique elements at the start in sorted order.
 * (Should be a generic list)
 */

public class SortList {

    public <T extends Comparable<T>> ArrayList sortWithDuplicateAtLast(List<T> list){

        HashSet<T> uniquesSet = new HashSet<>();
        ArrayList<T> duplicatesList = new ArrayList<>();
        HashSet<T> duplicatesSet = new HashSet<>();

        for (T element : list) {
            if(uniquesSet.contains(element)){
                uniquesSet.remove(element);
                duplicatesSet.add(element);
                duplicatesList.add(element);
                duplicatesList.add(element);
            }
            else if(duplicatesSet.contains(element))
                duplicatesList.add(element);
            else
                uniquesSet.add(element);
        }

        ArrayList<T> sortedList = createListFromSet(uniquesSet);

        sortList(sortedList);

        sortList(duplicatesList);

        sortedList.addAll(duplicatesList);

        return sortedList;

    }

    private <T extends Comparable<T>> void sortList(ArrayList<T> list) {
        Collections.sort(list);
    }

    private <T extends Comparable<T>> ArrayList createListFromSet(HashSet<T> uniquesSet) {
        return new ArrayList(uniquesSet);
    }

}
