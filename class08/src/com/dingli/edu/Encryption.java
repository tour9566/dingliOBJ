package com.dingli.edu;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num / (int)Math.pow(10, i) % 10;
            arr[i] += 5;
            arr[i] %= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
