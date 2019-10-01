package no.oslomet.cs.algdat;

public class Main {

    public static void main(String[] args) {
        String[] listeString = {"Anders", "Andersyt", "tommygrut", "theo"};
        Liste<String> liste = new DobbeltLenketListe<>(listeString);
        System.out.println(liste.antall() +" "+ liste.tom());

    }

}
