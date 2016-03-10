package org.fasttrackit.util;


public class Example {


    public static void main(String[] args) {
        Calc calc2= new Calc(3);

        int  suma=calc2.add(589,992);
        System.out.println("Suma numerelor este : " + suma);

        suma =calc2.add(3,50);
        System.out.println("Suma numerelor este : " + suma);

    }
}

