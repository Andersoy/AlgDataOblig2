package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////



import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;

import java.util.function.Predicate;


/*
Gruppemedlemmer:    S331398 - Anders Oeyrehagen
                    S330474 - Anders Magnus Ytterboee
                    S330473 - Tommy Grut
                    S331386 - Tobias Dyre Evju
                    S331359 - Theodor Fredheim Aandal
 */


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */

    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {

            this(verdi, null, null);

        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen
    private T[] generiskArray;


    public DobbeltLenketListe() {
        hode = hale = new Node(null);
        hode.neste=hale;
        hale.forrige=hode;
        antall = 0;
    }

    private void flyttVerdier(T[] a){
        int teller = 0;
        for(T i : a){
            if(i !=null){
                teller++;
            }
        }

        generiskArray = (T[]) new Object[teller];
        int index = 0;
        for(T i: a){
            if(i!=null){
                generiskArray[index]=i;
                index++;
            }
        }
    }

    public DobbeltLenketListe(T[] a) {
        antall = 0;

        if(a==null){
            throw new NullPointerException("Tabellen a er null!");
        }

        flyttVerdier(a);
        hode = hale = new Node(null);
        hode.neste  = hale;
        hale.forrige = hode;

        Node<T> p = hode;
        for (T i : generiskArray) {
            Node<T> q = new Node<>(i);
            p.neste = q;
            if (p != hode) {
                q.forrige = p;
            }
            p = q;
            antall++;
        }
        hale.forrige = p;
    }

    public Liste<T> subliste(int fra, int til){

        throw new NotImplementedException();
    }

    @Override
    public int antall() {
        return antall;

    }

    @Override
    public boolean tom() {
        if(antall==0){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean leggInn(T verdi) {
        boolean svar = false;
        T verdiNode = Objects.requireNonNull(verdi, "Nullverdier ikke tillatt");

        Node<T> q = new Node<>(verdiNode);


        //hvis listen er tom
        if(antall == 0) {
            hode.neste=q;
            hale.forrige=q;
            antall++;
            endringer++;
            svar = true;


        } else {   //hvis listen består av 1 eller flere
            Node<T> x = hale.forrige;
            x.neste = q;
            q.forrige = x;
            hale.forrige = q;
            svar = true;
            antall++;
            endringer++;
        }
        return svar;
    }


    @Override
    public void leggInn(int indeks, T verdi) {
        Node<T> p = hode;
        Node<T> q = new Node<>(verdi);

        for(int i = 0; i < indeks-1; i ++){
            p=p.neste;
        }
        Node<T> r=p.neste;

        q.neste=r;
        r.forrige=q;

        q.forrige=p;
        p.neste=q;
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public void nullstill() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        StringBuilder verdiString = new StringBuilder();

        if(antall == 0){
            return "[]";
        }
        else if(antall == 1){
            return "[" + hode.neste.verdi + "]";
        }

        else {
            Node p = hode.neste;

            verdiString.append("[" + p.verdi);
            p = p.neste;

            while (p != null) {
                verdiString.append(", " +p.verdi);
                p = p.neste;
            }
            verdiString.append("]");
            return verdiString.toString();
        }

    }

    public String omvendtString() {
        StringBuilder verdiString = new StringBuilder();

        if(antall == 0){
            return "[]";
        }
        else if(antall == 1){
            return "[" + hale.forrige.verdi + "]";
        }

        else {
            Node p = hale.forrige;

            verdiString.append("[" + p.verdi);
            p = p.forrige;

            while (p != null) {           // "p.verdi" her, og kun "p" i toString()-metoden. hvorfor??
                verdiString.append(", " +p.verdi);
                p = p.forrige;
            }
            verdiString.append("]");
            return verdiString.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            throw new NotImplementedException();
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public boolean hasNext(){
            throw new NotImplementedException();
        }

        @Override
        public T next(){
            throw new NotImplementedException();
        }

        @Override
        public void remove(){
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }

} // class DobbeltLenketListe


