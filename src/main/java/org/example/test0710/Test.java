package org.example.test0710;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("첫 번째 정수 입력: ");
//        int a = sc.nextInt();
//
//        System.out.print("두 번째 정수 입력: ");
//        int b = sc.nextInt();
//
//        double result = (double)a / b;
//
//        System.out.println(a == 0 ? "0으로 나눌 수 없습니다." : result);
//
//        sc.close();

        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int min = Integer.MAX_VALUE;

        System.out.print("정수 입력: ");
        int a = sc.nextInt();

        for(int i = 0; i < a; i++) {
            int randomNum = random.nextInt(min);
            numbers.add(randomNum);
        }

        for(int number: numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        min = numbers.get(0);
        for(int i = 0; i < numbers.size(); i++){
            if(min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }
        System.out.println("최소값: " + min);
        sc.close();
    }
}
