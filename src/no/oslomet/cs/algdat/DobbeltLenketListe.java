package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import com.sun.tools.javac.util.ArrayUtils;
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
        hode = hale = new Node<>(null);
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


        if(generiskArray.length!=0){
            Node<T> p = hode;
            for (T i : generiskArray) {
                Node<T> q = new Node<>(i);
                p.neste = q;
                q.forrige = p;
                p = q;
                antall++;
            }
            hale.forrige = p;

        }
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
        Node<T> p = hode;
        Node a = p.neste;
        boolean svar = false;

        for (int i = 0; i < antall; i++) {

            if (a.verdi.equals((T)verdi)) {
                svar=true;
                break;
            } else {
                svar=false;
            }
            a=a.neste;
        }
        return svar;
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        Node<T> p = hode;
        Node a = p.neste;
        int indeksSvar=0;

        if (inneholder(verdi)) {
            for (int i = 0; i < antall; i ++) {
                if(a.verdi.equals(verdi)) {
                    indeksSvar=i;
                    break;
                }
                a=a.neste;
            }
        } else {
            indeksSvar=-1;
        }


        return indeksSvar;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        boolean fjern;
        int indeks = -1;

        if(antall == 0 || verdi == null){
            return false;
        }

        if(antall == 1){
            hode.neste = hale;
            hale.forrige = hode;
            antall--;
            endringer++;
            return true;
        }

        Node<T> p = hode;

        for(int i = 0; i < antall; i++){
            p = p.neste;
            if(p.verdi.equals(verdi)) {
                indeks = i;
                break;
            }
        }
        if(p.forrige == null){
            p = hode;
        }
        else {
            p = p.forrige;
        }

        Node<T> q = p.neste;

        if(indeks == -1){
            fjern = false;
        }

        else if (indeks == 0) {
            //q er første element
            Node<T> r = q.neste;
            r.forrige = null;
            hode.neste = r;
            antall--;
            endringer++;
            fjern = true;
        }

        else if (indeks == antall-1) {
            //q er siste element
            p.neste = null;
            hale.forrige = p;
            antall--;
            endringer++;
            fjern = true;
        }

        else {
            //Normal fjerning i midten av listen
            Node<T> r = q.neste;
            p.neste = r;
            r.forrige = p;
            antall--;
            endringer++;
            fjern = true;
        }
        return fjern;
    }

    @Override
    public T fjern(int indeks) {

        if(antall == 0){
            throw new IndexOutOfBoundsException("Listen er tom");
        }

        if(indeks < 0 || indeks >= antall){
            throw new IndexOutOfBoundsException("Indeks utenfor listen");
        }

        if(antall == 1){
            hode.neste = hale;
            hale.forrige = hode;
        }

        Node<T> p = hode;

        for (int i= 0; i<indeks; ++i) {
            p = p.neste;
        }
        Node<T> q = p.neste;

        if (indeks == 0) {
            //q er første element
            Node<T> r = q.neste;
            r.forrige = null;
            hode.neste = r;
            antall--;
            endringer++;

        }
        else if (indeks == antall-1) {
            //q er siste element
            p.neste = null;
            hale.forrige = p;
            antall--;
            endringer++;
        }
        else {
            //Normal fjerning i midten av listen
            Node<T> r = q.neste;
            p.neste = r;
            r.forrige = p;
            antall--;
            endringer++;
        }
        return q.verdi;
    }
/*
    @Override
    public void nullstill() {
        Node<T> p = hode;
        Node<T> q = p.neste;
        Node<T> r = q.neste;
        while(antall > 0){
            p.neste = r;
            r.forrige = p;
            antall--;
            endringer++;
        }


    }*/

    @Override
    public void nullstill() {
        while (antall > 0) {
            fjern(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder verdiString = new StringBuilder();

        if(antall == 0){
            return "[]";
        }

        else if (antall == 1){
            return "["+hode.neste.verdi+"]";
        }

        else{
            Node p = hode.neste;

            verdiString.append("["+ p.verdi);
            p =p.neste;

            while (p != null){
                verdiString.append(", "+p.verdi);
                p = p.neste;
            }
            verdiString.append("]");
            System.out.println(verdiString.toString());
            return  verdiString.toString();
        }
    }

    public String omvendtString() {
        StringBuilder verdiString = new StringBuilder();

        if(antall == 0){
            return "[]";
        }

        else if (antall == 1){
            return "["+hode.neste.verdi+"]";
        }

        else{
            Node p = hale.forrige;

            verdiString.append("["+ p.verdi);
            p =p.forrige;

            while (p != null){
                verdiString.append(", "+p.verdi);
                p = p.forrige;
            }
            verdiString.append("]");
            System.out.println(verdiString.toString());
            return  verdiString.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        /*Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        return iterator;*/
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
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public T next(){
            if(endringer != iteratorendringer){
                throw new ConcurrentModificationException("Ikke likt");
            }

            if(!hasNext()){
                throw new NoSuchElementException("");
            }

            fjernOK = true;
            return denne.verdi;
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


