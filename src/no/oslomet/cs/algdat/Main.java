package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        String[] listeString = {"Anders", "Andersyt", "tommygrut", "theo"};
//        Integer[] listeString = {};
//        System.out.println(Arrays.toString(listeString));
//        System.out.println(listeString.length);
//        Liste<Integer> liste = new DobbeltLenketListe<>(listeString);
//
//        System.out.println(liste.antall() +" "+ liste.tom());

        String[] s = {"123"};
        DobbeltLenketListe<String> l = new DobbeltLenketListe<>(s);

     //   System.out.println(l.toString());
     //  System.out.println(l.omvendtString());


        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());

    }

}
