package com.hashmap.excercise.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Palindrome {

    public boolean checkPalindrome(String s) {

        HashSet<Character> h = new HashSet<>();

        for (int i=0; i<s.length(); i++){
            if(h.contains(s.charAt(i)))
                h.remove(s.charAt(i));
            else
                h.add(s.charAt(i));
        }

        if(h.size()==0||h.size()==1)
            return true;
        else
            return false;
    }
}
