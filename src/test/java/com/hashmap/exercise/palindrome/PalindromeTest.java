package com.hashmap.exercise.palindrome;

import com.hashmap.excercise.palindrome.Palindrome;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

    Palindrome palindrome;

    @Before
    public void init(){
        palindrome = new Palindrome();
    }

    @Test
    public void checkPalindromeTest1(){
        Assert.assertEquals(true, palindrome.checkPalindrome("aallhdd"));
    }

    @Test
    public void checkPalindromeTest2(){
        Assert.assertEquals(false, palindrome.checkPalindrome("aalhdd"));
    }


}
