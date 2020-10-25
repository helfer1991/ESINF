/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import esinf.DoublyLinkedList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ISEP
 */
public class DoublyLinkedListTest {
    
    public DoublyLinkedListTest() {
    }
    
    /**
     * Test of size method, of class DoublyLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DoublyLinkedList instance = new DoublyLinkedList();
        assertTrue("result should be zero", (instance.size()==0));
        instance.addFirst(null);
        assertTrue("result should be one", (instance.size()==1));
        instance.addLast(null);
        assertTrue("result should be two", (instance.size()==2));
        instance.removeFirst();
        assertTrue("result should be one", (instance.size()==1));
        instance.removeLast();
        assertTrue("result should be zero", (instance.size()==0));
    }

    /**
     * Test of isEmpty method, of class DoublyLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        DoublyLinkedList instance = new DoublyLinkedList();

        assertTrue("result should be yes", (instance.isEmpty()==true));
        instance.addFirst(null);
        assertTrue("result should be no", (instance.isEmpty()==false));
        instance.addLast(null);
        assertTrue("result should be no", (instance.isEmpty()==false));
        instance.removeFirst();
        assertTrue("result should be no", (instance.isEmpty()==false));
        instance.removeLast();
        assertTrue("result should be yes", (instance.isEmpty()==true));
    }

    /**
     * Test of first method, of class DoublyLinkedList.
     */
    @Test
    public void testFirst() {
        System.out.println("first");
        DoublyLinkedList <String> instance = new DoublyLinkedList<>();

        assertTrue("result should be null", (instance.first()==null));
        instance.addFirst("Xpto");
        assertTrue("result should be Xpto", (instance.first().compareTo("Xpto")==0));
        instance.addLast("Ypto");
        assertTrue("result should be Xpto", (instance.first().compareTo("Xpto")==0));
        instance.removeFirst();
        assertTrue("result should be Ypto", (instance.first().compareTo("Ypto")==0));
        instance.removeLast();
        assertTrue("result should be null", (instance.first()==null));
    }

    /**
     * Test of last method, of class DoublyLinkedList.
     */
    @Test
    public void testLast() {
        System.out.println("last");
        DoublyLinkedList <String> instance = new DoublyLinkedList <>();

        assertTrue("result should be null", (instance.last()==null));
        instance.addFirst("Xpto");
        assertTrue("result should be Xpto", (instance.last().compareTo("Xpto")==0));
        instance.addLast("Ypto");
        assertTrue("result should be Ypto", (instance.last().compareTo("Ypto")==0));        
        instance.removeLast();
        assertTrue("result should be Xpto", (instance.last().compareTo("Xpto")==0));
        instance.removeFirst();        
        assertTrue("result should be null", (instance.last()==null));        
    }

    /**
     * Test of addFirst method, of class DoublyLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        DoublyLinkedList <String> instance = new DoublyLinkedList <>();
        
        instance.addFirst("Xpto");
        assertTrue("result should be Xpto", (instance.first().compareTo("Xpto")==0));
        instance.addFirst("Ypto");
        assertTrue("result should be Ypto", (instance.first().compareTo("Ypto")==0));
        instance.addFirst("Zpto");
        assertTrue("result should be Zpto", (instance.first().compareTo("Zpto")==0));
    }

    /**
     * Test of addLast method, of class DoublyLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        DoublyLinkedList <String> instance = new DoublyLinkedList <>();
        
        instance.addLast("Xpto");
        assertTrue("result should be Xpto", (instance.last().compareTo("Xpto")==0));
        instance.addLast("Ypto");
        assertTrue("result should be Ypto", (instance.last().compareTo("Ypto")==0));
        instance.addLast("Zpto");
        assertTrue("result should be Zpto", (instance.last().compareTo("Zpto")==0));
    }

    /**
     * Test of removeFirst method, of class DoublyLinkedList.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        DoublyLinkedList <String> instance = new DoublyLinkedList <>();
        
        instance.addFirst("Xpto");
        instance.addFirst("Ypto");
        instance.addFirst("Zpto");
        
        assertTrue("result should be Zpto", (instance.removeFirst().compareTo("Zpto")==0));
        assertTrue("result should be Ypto", (instance.removeFirst().compareTo("Ypto")==0));        
        assertTrue("result should be Xpto", (instance.removeFirst().compareTo("Xpto")==0));
        assertTrue("result should be null", (instance.removeFirst()==null));        
    }

    /**
     * Test of removeLast method, of class DoublyLinkedList.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        DoublyLinkedList <String> instance = new DoublyLinkedList <>();
        
        instance.addLast("Xpto");
        instance.addLast("Ypto");
        instance.addLast("Zpto");
        
        assertTrue("result should be Zpto", (instance.removeLast().compareTo("Zpto")==0));
        assertTrue("result should be Ypto", (instance.removeLast().compareTo("Ypto")==0));        
        assertTrue("result should be Xpto", (instance.removeLast().compareTo("Xpto")==0));
        assertTrue("result should be null", (instance.removeLast()==null));
    }
    
    
    /**
     * Test of overridden equals method, of class DoublyLinkedList.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        DoublyLinkedList <String> instance1 = new DoublyLinkedList <>(), instance2 = new DoublyLinkedList <>();
        
        instance1.addLast("Xpto");
        instance1.addLast("Ypto");
        instance1.addLast("Zpto");
        
        instance2.addLast("Xpto");
        assertFalse("Lists should not be equal", (instance1.equals(instance2)));
        assertFalse("Lists should not be equal", (instance2.equals(instance1)));        
        instance2.addLast("Ypto");
        assertFalse("Lists should not be equal", (instance1.equals(instance2)));
        assertFalse("Lists should not be equal", (instance2.equals(instance1)));
        instance2.addLast("Zpto");
        assertTrue("Lists should be equal", (instance1.equals(instance2)));
        assertTrue("Lists should be equal", (instance2.equals(instance1)));       
    }    
    /**
     * Test of overridden equals method, of class DoublyLinkedList.
     * @throws java.lang.CloneNotSupportedException
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        System.out.println("clone");
        DoublyLinkedList <String> instance1 = new DoublyLinkedList <>(), instance2;
        
        instance1.addLast("Xpto");
        instance1.addLast("Ypto");
        instance1.addLast("Zpto");
        
        instance2 = (DoublyLinkedList<String>) instance1.clone();
        
        assertTrue("Lists should be of equal size", (instance1.size()==instance2.size()));
        Iterator <String> it1=instance1.iterator();       // ITerator for This list
        Iterator <String> it2=instance2.iterator();      // ITerator for the Other list
        while (it1.hasNext())
        {
            String el1=it1.next(), el2=it2.next();
            assertTrue("Elements should be the equal",(el1.equals(el2)));
        }
        
        // check deep structure
        instance2.removeLast();
        instance2.removeLast();
        instance2.removeLast();
        
        it1=instance1.iterator();       // ITerator for This list
        Integer total=0;
        while (it1.hasNext())
        {
            it1.next();
            total++;
        }
        assertTrue("List should have remained the same",(total==3));                
    }        
}
