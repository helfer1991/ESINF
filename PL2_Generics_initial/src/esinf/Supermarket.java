/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    Map <Invoice, Set<Product>> m;
    
    Supermarket() {
        m = new HashMap<>();
    }
    
    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {
        Invoice currentInvoiceReference = null;
        
        for(String line : l) {
            String[] lineData = line.split(",");
            if("I".equals(lineData[0])) { //para invoice
                Invoice invoice = new Invoice(lineData[1], lineData[2]);
                currentInvoiceReference = invoice;
                m.put(invoice, new HashSet<>());
            }
            if("P".equals(lineData[0])) { // para product
                Set<Product> products = m.get(currentInvoiceReference);
                products.add(new Product(lineData[1], Integer.parseInt(lineData[2]), Long.parseLong(lineData[3])));
            }
        }
        for(Invoice name: m.keySet()){
            String key = name.toString();
            String value = m.get(name).toString();
            System.out.println(key + " " + value);
        }
    }   
    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> map = new HashMap<>();
        
        for(Invoice invoice : m.keySet()) {
            Set<Product> products = m.get(invoice);
            map.put(invoice, products.size());
        }
        return map;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set <Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invoiceDates = new HashSet<>();
        
        for(Invoice invoice : m.keySet()) {
            if(invoice.getDate().compareTo(d1) > 0 && invoice.getDate().compareTo(d2) < 0) {
                invoiceDates.add(invoice);
            }
        }
        return invoiceDates;
    }
    
    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long total = 0;
        
        for(Invoice invoice : m.keySet()) {
            for(Product product : m.get(invoice)) {
                if(product.getIdentification().equals(productId)) {
                    total += product.getPrice() * product.getQuantity();
                }
            }
        }
        return total;
    }
    
    // converts a map of invoices and troducts to a map which key is a product 
    // identification and the values are a set of the invoice references 
    // in which it appearss
    Map <String, Set<Invoice>> convertInvoices() {
        Map<String, Set<Invoice>> newMap = new HashMap<>();
        
        for(Invoice invoice : m.keySet()) {
            for(Product product : m.get(invoice)) {
                newMap.put(product.getIdentification(), new HashSet<>());
            }
        }
        
        for(Invoice invoice : m.keySet()) {
            for(Product product : m.get(invoice)) {
                Set<Invoice> invoiceProduct = newMap.get(product.getIdentification());
                invoiceProduct.add(invoice);
            }
        }
        return newMap;
    }
}
