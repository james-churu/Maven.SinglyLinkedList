package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest<T> {


    @Test
    public void addAndSizeTest(){
        SinglyLinkedList linky = new SinglyLinkedList();

        Integer expected = 0;
        Integer aatual = linky.getSize(linky.getHead());

        Assert.assertEquals(expected , aatual);

        String name = "Jimmt";
        linky.add(name);

        Integer expected1 = 1;
        Integer aatual1 = linky.getSize(linky.getHead());

        Assert.assertEquals(expected1 , aatual1);

    }
    @Test
    public void removeFromMidTest(){

        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        Integer expected = 0;
        Integer aatual = linky.getSize(linky.getHead());
        Assert.assertEquals(expected , aatual);

        linky.add("elem1");
        linky.add("elem2");
        linky.add("elem3");
        linky.add("elem4");
        linky.add("elem5");
        linky.add("elem6");

        // Before removing
        Integer expectedSize = 6;
        Integer actualSize = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize , actualSize);

        //After removing
        String valuue = linky.remove(3);                           // Removed "elem4" at index 3
        Integer expectedSizeAfterremove = 5;                              // Size should be 1 ;ess
        Integer actualsizeAfterRemove = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSizeAfterremove , actualsizeAfterRemove);


        String actualValue =  (String)linky.getValue(3); // element at index 3 - SHOUL NOW Be elem5
        String expectedValue = "elem5";
        Assert.assertEquals(expectedValue , actualValue);
    }
    @Test
    public void removeFromSizeOfOneTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");

        Integer expectedSize = 1;
        Integer actualSize = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize , actualSize);

        linky.remove(0);
        Integer expectedSize2 = 0;
        Integer actualSize2 = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize2 , actualSize2);
    }
    @Test
    public void removeFromEndTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");
        linky.add("elem2");

        Integer expectedSize = 2;
        Integer actualSize = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize , actualSize);

        linky.remove(1);
        Integer expectedSize2 = 1;
        Integer actualSize2 = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize2 , actualSize2);

        String actualValue = linky.getValue(0); // element at index 3 - SHOULD NOW Be elem5
        String expectedValue = "elem1";
        Assert.assertEquals(expectedValue , actualValue);

    }
    @Test
    public void removeFromBeginingTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");
        linky.add("elem2");

        Integer expectedSize = 2;
        Integer actualSize = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize , actualSize);

        linky.remove(0);
        Integer expectedSize2 = 1;
        Integer actualSize2 = linky.getSize(linky.getHead());
        Assert.assertEquals(expectedSize2 , actualSize2);
    }
    @Test
    public void findTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");
        linky.add("elem2");
        linky.add("elem3");
        linky.add("elem4");

        Integer expectedIndex = 2;
        Integer actualIndex = linky.find("elem3");
        Assert.assertEquals(expectedIndex , actualIndex);

        Integer expectedIndex1 = 0;
        Integer actualIndex1 = linky.find("elem1");
        Assert.assertEquals(expectedIndex1 , actualIndex1);

        Integer expectedIndex2 = -1;
        Integer actualIndex2 = linky.find("elem9");
        Assert.assertEquals(expectedIndex2 , actualIndex2);
    }
    @Test
    public void containsTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");

        Assert.assertTrue(linky.contains("elem1"));
        Assert.assertFalse(linky.contains("elem2"));
    }
    @Test
    public void getValueTest(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");

        String expected = "elem1";
        String actual =  linky.getValue(0);
        Assert.assertEquals(expected , actual);
    }
    @Test
    public void copy(){
        SinglyLinkedList<String> linky = new SinglyLinkedList<>();
        linky.add("elem1");

        SinglyLinkedList<String> linkyCloned =  linky.copy();

        Assert.assertEquals(linky  , linkyCloned);
    }

}
