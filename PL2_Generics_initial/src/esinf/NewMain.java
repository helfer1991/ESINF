/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("I,INV001,2016/09/10");
        lista.add("P,EGG,12,200");
        lista.add("P,APPLE,2,140");
        lista.add("P,BUTTER,1,100");
        lista.add("I,INV002,2016/09/11");
        lista.add("P,PEAR,3,230");
        lista.add("P,CHIPS,3,320");
        lista.add("P,EGG,6,100");
        lista.add("I,INV003,2016/09/12");
        lista.add("P,BUTTER,2,200");
        lista.add("P,APPLE,3,210");
        lista.add("P,CHIPS,2,210");
        lista.add("P,PEAR,5,350");
        lista.add("I,INV004,2016/09/13");
        lista.add("P,COCONUT,1,240");
        lista.add("P,APPLE,2,140");
        lista.add("P,BUTTER,2,200");
        lista.add("P,PINEAPPLE,2,310");

        Supermarket supermarket = new Supermarket();

        try {
            supermarket.getInvoices(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
