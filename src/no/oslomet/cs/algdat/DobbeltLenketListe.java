package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
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

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;

    }



    public DobbeltLenketListe(T[] a) {

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
        Node<T> q = new Node<>(verdi);

        if(hale == null) {
            hode=q;
            hale=q;
            q.neste=null;
            q.forrige=null;
            antall++;
            endringer++;
        } else {
            q.forrige=hale;
            hale.neste=q;
            hale=q;
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
        StringBuilder strengBygger = new StringBuilder();

        Node p = hode;
        p=p.neste;

        while(p != null) {
            strengBygger.append(p.verdi);
            p=p.neste;
        }
        return strengBygger.toString();
    }

    public String omvendtString() {
        StringBuilder strengBygger = new StringBuilder();

        Node q = hale;
        q=q.forrige;

        while (q != null) {
            strengBygger.append(q.verdi);
            q=q.forrige;
        }
        return strengBygger.toString();
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


