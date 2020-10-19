/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ISEP
 */
public class InvoiceTest {
    
    public InvoiceTest() {
    }

    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals01() {
        System.out.println("equals01");
        Object obj = new Invoice("Invoice001","2016/9/10");
        Invoice instance = new Invoice("Invoice002","2016/9/10");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals02() {
        System.out.println("equals02");
        Object obj = new Invoice("Invoice001","2011/9/10");
        Invoice instance = new Invoice("Invoice001","2016/9/10");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Invoice.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Invoice instance = new Invoice("Invoice001","2011/9/10");
        int expResult = instance.getReference().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Invoice.
     */
    @Test
    public void testCompareTo01() {
        System.out.println("compareTo01");
        Invoice o = new Invoice("Invoice001","2011/9/10");
        Invoice instance = new Invoice("Invoice002","2011/9/10");
        int result = instance.compareTo(o);
        assertTrue(result>0);
    }
    /**
     * Test of compareTo method, of class Invoice.
     */
    @Test
    public void testCompareTo02() {
        System.out.println("compareTo02");
        Invoice o = new Invoice("Invoice002","2011/9/10");
        Invoice instance = new Invoice("Invoice001","2011/9/10");
        int result = instance.compareTo(o);
        assertTrue(result<0);
    }    
    /**
     * Test of compareTo method, of class Invoice.
     */
    @Test
    public void testCompareTo03() {
        System.out.println("compareTo03");
        Invoice o = new Invoice("Invoice001","2016/9/10");
        Invoice instance = new Invoice("Invoice001","2016/9/10");
        int result = instance.compareTo(o);
        assertTrue(result==0);
    }        
    
}
