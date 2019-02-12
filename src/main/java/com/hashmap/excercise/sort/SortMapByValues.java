package com.hashmap.excercise.sort;

import java.util.*;


/**
 * SORT MAP BY VALUES
 *
 */


public class SortMapByValues {

    public <K,V extends Comparable<V>> Map<K, V> sortMapByValues(Map<K,V> map){
        Map<K,V> sortedMap = new LinkedHashMap<>();

        ArrayList<MyMap<K,V>> mappings = new ArrayList<>();

        createMappings(map, mappings);

        Collections.sort(mappings);

        sortedMap = createSortedMap(mappings);
        return sortedMap;
    }

    private <K, V extends Comparable<V>> Map<K,V> createSortedMap(ArrayList<MyMap<K,V>> mappings) {

        LinkedHashMap<K,V> sortedMap = new LinkedHashMap();

        for(int i=0; i<mappings.size(); i++){
            sortedMap.put(mappings.get(i).key, mappings.get(i).value);
        }

        return sortedMap;
    }

    private <K, V extends Comparable<V>> void createMappings(Map<K,V> map, ArrayList<MyMap<K,V>> mappings) {
        Set<K> keys  = map.keySet();

        for (K key:keys)
            mappings.add(new MyMap<>(key, map.get(key)));
    }

    private class MyMap<K,V extends Comparable<V>> implements Comparable<MyMap>{
        K key;
        V value;

        public MyMap(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(MyMap myMap) {

            return value.compareTo((V) myMap.getValue());
        }
    }


}

