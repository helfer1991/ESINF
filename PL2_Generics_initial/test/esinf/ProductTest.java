/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ISEP
 */
public class ProductTest {
    
    public ProductTest() {
    }


    /**
     * Test of equals method, of class Product.
     */
    @Test
    public void testEquals01() {
        System.out.println("equals01");
        Object obj = new Product("P001",0,0);
        Product instance = new Product("P002",0,0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class Product.
     */
    @Test
    public void testEquals02() {
        System.out.println("equals02");
        Object obj = new Product("P001",0,0);
        Product instance = new Product("P001",1,1);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }    

    /**
     * Test of hashCode method, of class Product.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Product instance = new Product("P001",1,1);
        int expResult = instance.getIdentification().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Product.
     */
    @Test
    public void testCompareTo01() {
        System.out.println("compareTo01");
        Product o = new Product("P002",1,1);
        Product instance = new Product("P001",2,2);
        int result = instance.compareTo(o);
        assertTrue(result<0);

    }        
    /**
     * Test of compareTo method, of class Product.
     */
    @Test
    public void testCompareTo02() {
        System.out.println("compareTo02");
        Product o = new Product("P001",1,1);
        Product instance = new Product("P002",2,2);
        int result = instance.compareTo(o);
        assertTrue(result>0);

    }    
    /**
     * Test of compareTo method, of class Product.
     */
    @Test
    public void testCompareTo03() {
        System.out.println("compareTo03");
        Product o = new Product("P001",1,1);
        Product instance = new Product("P001",2,2);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);

    }
    
}
