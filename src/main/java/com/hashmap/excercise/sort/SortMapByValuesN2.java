package com.hashmap.excercise.sort;

import java.util.*;

/**
 * SORT MAP BY VALUES
 *
 *
 * Time Complexity is O(N2)
 */

public class SortMapByValuesN2 {

    public <K,V extends Comparable<V>> Map<K, V> sortMap(Map<K,V> map){

        ArrayList<K> keys;
        ArrayList<V> values;

        keys = extractKeys(map);

        values = extractValues(map);

        sortValues(values);

        Map<K,V> sortedMap = new LinkedHashMap<>();

        for (int i=0; i<values.size(); i++){
            for (int j=0; j<keys.size(); j++){
                if(values.get(i)==map.get(keys.get(j))){
                    sortedMap.put(keys.get(j), values.get(i));
                    keys.remove(j);
                    break;
                }
            }
        }


        return sortedMap;
    }

    private <K, V extends Comparable<V>> ArrayList<V> extractValues(Map<K,V> map) {
        return new ArrayList<>(map.values());
    }

    private <K, V extends Comparable<V>> ArrayList<K> extractKeys(Map<K,V> map) {
        return new ArrayList<>(map.keySet());
    }

    private <V extends Comparable<V>> void sortValues(ArrayList<V> values) {
        Collections.sort(values);
    }


}
