/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ISEP
 */
public class SupermarketTest {
    private Supermarket instance;
    
    public SupermarketTest() throws IOException, Exception {
        instance = new Supermarket();
        List<String> l = Files.lines(Paths.get("invoices.txt")).collect(Collectors.toList());
        instance.getInvoices(l);        
    }

    @Test
    public void testNumberOfProductsPerInvoice() throws IOException {
        System.out.println("numberOfProductsPerInvoice");        
        Map<Invoice,Integer> result = new HashMap<>();
        result.put(new Invoice("INV001"),3);
        result.put(new Invoice("INV002"),3);
        result.put(new Invoice("INV003"),4);
        result.put(new Invoice("INV004"),4);
        
        Map<Invoice,Integer> expResult = instance.numberOfProductsPerInvoice();
        assertEquals(expResult, result);
    }

    @Test
    public void testBetweenDates() {
        System.out.println("betweenDates");
        LocalDate d1 = LocalDate.of(2016, 9, 10);
        LocalDate d2 = LocalDate.of(2016, 9, 13);
        Set<Invoice> result = instance.betweenDates(d1, d2);
        
        assertTrue(result.remove(new Invoice("INV002")));
        assertTrue(result.remove(new Invoice("INV003")));            
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTotalOfProduct() {
        System.out.println("totalOfProduct");
        String productId = "APPLE";
        long result = instance.totalOfProduct(productId);
        long expResult = 1190;
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertInvoices() {
        System.out.println("convertInvoices");
        Map<String, Set<Invoice>> result = instance.convertInvoices();
        Set <Invoice> r = result.get("COCONUT");
        assertTrue(r.contains(new Invoice("INV004",null)));
        r = result.get("APPLE");
        assertTrue(r.contains(new Invoice("INV001",null)));
        assertTrue(r.contains(new Invoice("INV003",null)));                
        assertTrue(r.contains(new Invoice("INV004",null)));
        r = result.get("PEAR");
        assertTrue(r.contains(new Invoice("INV002",null)));
        assertTrue(r.contains(new Invoice("INV003",null)));                
        r = result.get("EGG");
        assertTrue(r.contains(new Invoice("INV001",null)));
        assertTrue(r.contains(new Invoice("INV002",null)));                
        r = result.get("BUTTER");
        assertTrue(r.contains(new Invoice("INV001",null)));
        assertTrue(r.contains(new Invoice("INV003",null)));                
        assertTrue(r.contains(new Invoice("INV004",null)));
        r = result.get("CHIPS");
        assertTrue(r.contains(new Invoice("INV002",null)));
        assertTrue(r.contains(new Invoice("INV003",null)));                
        r = result.get("PINEAPPLE");
        assertTrue(r.contains(new Invoice("INV004",null)));
    }    
}
