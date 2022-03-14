package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Choose argument in degrees(D) or radians(R)? ");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        switch (ans) {
            case "D", "d" -> {
                System.out.print("Input value in degrees: ");
                sinX(Math.PI / 180 * (Double.parseDouble(scanner.nextLine())));
            }
            case "R", "r" -> {
                System.out.print("Input value in radians: ");
                sinX(Double.parseDouble(scanner.nextLine()));
            }
            default -> System.out.println("Incorrect argument");
        }
    }

    public static void sinX(double x) {
        double result = 0;
        double dif = 0;
        double sinRes = Math.sin(x);
        while (x > Math.PI * 2) {
            x -= Math.PI * 2;
        }
        while (x < 0) {
            x += Math.PI * 2;
        }

        if (x > Math.PI / 2 && x < Math.PI) {
            x = Math.PI - x;
        } else if (x > Math.PI && x < Math.PI * 3 / 2) {
            x = Math.PI - x;
        } else if (x > Math.PI * 3 / 2 && x < Math.PI * 2) {
            x = x - Math.PI * 2;
        }

        result = x;
        System.out.println("№\t" + "step_value\t\t\t" + "diference");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                result += Math.pow(x, i * 2 + 1) / factorial(i * 2 + 1);
            } else {
                result -= Math.pow(x, i * 2 + 1) / factorial(i * 2 + 1);
            }
            dif = Math.abs(sinRes - result);
            System.out.println(i + "\t" + result + "\t" + dif);
        }
        System.out.println("My result value: " + result);
        System.out.println("Math library value: " + sinRes);
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
