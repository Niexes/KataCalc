package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.Convert.arabicToRoman;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String vvod = sc.nextLine();
        //sc.nextLine();
        System.out.println(calc(vvod));
    }

    public static String calc(String a) throws IOException {
        String[] array = a.split(" ");


        boolean A = ((a.contains("1") || (a.contains("2") || a.contains("3") || a.contains("4") || a.contains("5") || a.contains("6") || a.contains("7")
                || a.contains("8") || a.contains("9") || a.contains("10"))));

        boolean R = (a.contains("I") || a.contains("V") || a.contains("X"));



        if (array.length == 3 && (array[1].equals("+") || array[1].equals("-") || array[1].equals("/") || array[1].equals("*")) && ((R && !A) || (!R && A))) {
            //вариант для римских цифр
            if ( R && !A) {
                return funcRome(array);


                //вариант для арабских цифр
            } else if (!R && A) {
               return funcArab(array);

            }


        } else if (array.length < 3) {
            throw new IOException("throws Exception //т.к. строка не является математической операцией");
        } else if ((array.length > 3) && (a.contains("+") || a.contains("-") || a.contains("*") || a.contains("/"))) {
            throw new IOException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n" +
                    "\n");
        } else if ((array.length == 3 && R && A)) {
            throw new IOException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        return null;
    }


    public static String funcRome(String[] a) throws IOException{ // II+III преобразование для римских цифр
        String temp = a[1]; // +
        a[1] = "0";
        switch (a[0]) {
            case "I":
                a[0] = "1";
                break;
            case "II":
                a[0] = "2";
                break;
            case "III":
                a[0] = "3";
                break;
            case "IV":
                a[0] = "4";
                break;
            case "V":
                a[0] = "5";
                break;
            case "VI":
                a[0] = "6";
                break;
            case "VII":
                a[0] = "7";
                break;
            case "VIII":
                a[0] = "8";
                break;
            case "IX":
                a[0] = "9";
                break;
            case "X":
                a[0] = "10";
                break;

        }
        switch (a[2]) {
            case "I":
                a[2] = "1";
                break;
            case "II":
                a[2] = "2";
                break;
            case "III":
                a[2] = "3";
                break;
            case "IV":
                a[2] = "4";
                break;
            case "V":
                a[2] = "5";
                break;
            case "VI":
                a[2] = "6";
                break;
            case "VII":
                a[2] = "7";
                break;
            case "VIII":
                a[2] = "8";
                break;
            case "IX":
                a[2] = "9";
                break;
            case "X":
                a[2] = "10";
                break;
        }

        int[] aInt2 = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int b = 0; // представление результата в арабской системе
        String c = null;
        if (temp.equals("+")) {
            b = aInt2[0] + aInt2[2];
            c = Integer.toString(b);


        } else if (temp.equals("-")) {
            b = aInt2[0] - aInt2[2];
            if (b < 0) {
                throw new IOException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
            c = Integer.toString(b);


        } else if (temp.equals("/")) {
            b = aInt2[0] / aInt2[2];
            c = Integer.toString(b);


        } else if (temp.equals("*")) {
            b = aInt2[0] * aInt2[2];
            c = Integer.toString(b);
        }
        return arabicToRoman(b);


    }

    public static String funcArab(String[] a) throws IOException {
        String temp1 = a[1];
        String c = "Invalid arguments";
        a[1] = "0";
        int[] aInt = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int b = 0;
        for (int i = 0; i < a.length; i++) {
            if ((aInt[0] <= 10) && (aInt[2] <= 10)) {
                if (temp1.equals("+")) {
                    b = aInt[0] + aInt[2];
                    c = Integer.toString(b);


                } else if (temp1.equals("-")) {
                    b = aInt[0] - aInt[2];
                    c = Integer.toString(b);


                } else if (temp1.equals("/")) {
                    b = aInt[0] / aInt[2];
                    c = Integer.toString(b);


                } else if (temp1.equals("*")) {
                    b = aInt[0] * aInt[2];
                    c = Integer.toString(b);
                }
            }

        }
        if (c.equals("Invalid arguments")) {
            throw new IOException("throws Exception//т.к. калькулятор должен принимать на вход числа от 1 до 10 включительно");
        }
        return c;


    }
}





