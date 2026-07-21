package org;

public class Main {
    static int a = 1;
    static int b = 2;
    static double c = 3.2;

    public static void main (String [] args) {
        int sum = a + b;
        int diff = b-a;
        int div = b/a;
        int mult = a*b;

        System.out.println("Арифметические операции:");
        System.out.println("Сумма чисел: " + a + " + " + b + " = " + sum);
        System.out.println("Разность чисел: " + b + " - " + a + " = " + diff);
        System.out.println("Деление чисел: " + b + " / " + a + " = " + div);
        System.out.println("Умножение чисел: " + a + " * " + b + " = " + mult);
        System.out.println("--------------------------");

        double sumDouble = c + b;
        double diffDouble = c - b;
        double divDouble = c / b;
        double multDouble = c * b;

        System.out.println("Арифметические операции над int и double в одном выражении :");
        System.out.println("Сумма чисел: " + c + " + " + b + " = " + sumDouble);
        System.out.println("Разность чисел: " + c + " - " + b + " = " + diffDouble);
        System.out.println("Деление чисел: " + c + " / " + b + " = " + divDouble);
        System.out.println("Умножение чисел: " + c + " * " + b + " = " + multDouble);
        System.out.println("--------------------------");

        System.out.println("Логические операции:");
        System.out.println(sumDouble + " < " + sum + " = " + (sumDouble<sum));
        System.out.println(sumDouble + " > " + sum + " = " + (sumDouble>sum));
        System.out.println(sumDouble + " >= " + sum + " = " + (sumDouble>=sum));
        System.out.println(div + " <= " + mult + " = " + (div<=mult));
        System.out.println("--------------------------");

        System.out.println("Диапазоны:");
        System.out.println("float MIN: " + Float.MIN_VALUE);
        System.out.println("float MAX: " + Float.MAX_VALUE);
        System.out.println("double MIN: " + Double.MIN_VALUE);
        System.out.println("double MAX: " + Double.MAX_VALUE);

        System.out.println("Переполнение:");
        System.out.println("Float.MAX * 2 = " + (Float.MAX_VALUE * 2));   // Infinity
        System.out.println("Float.MAX * -2 = " + (Float.MAX_VALUE * -2));
    }
}
