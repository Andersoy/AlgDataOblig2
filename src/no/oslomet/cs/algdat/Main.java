package no.oslomet.cs.algdat;

public class Main {

    public static void main(String[] args) {
        String[] listeString = {null, null, null, null};
        System.out.println(listeString.length);
        Liste<String> liste = new DobbeltLenketListe<>(listeString);
        System.out.println(liste.tom());
        //System.out.println(liste.antall() +" "+ liste.tom());

    }

}
