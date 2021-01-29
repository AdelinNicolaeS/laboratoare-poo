package com.oop_pub.exceptions.ex2_3;

import java.util.Arrays;

public class MainEx2 {
    public static void main(String[] args) {
        Calculator calculator;
        calculator = new Operations();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(Arrays.asList(1d, 2d, 3d, 4d)));

        // consider ca exceptiile trebuie sa fie de tip checked deoarece acest tip de exceptie
        // permite de la inceput dezvoltatorului sa observe greselile de la nivelul resurselor
        // pe cand exceptiile unchecked se bazeaza pe erorile de logica ale programatorului
    }
}
