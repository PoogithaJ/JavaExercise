package org.example;

import java.util.Scanner;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ThreadPoolExecutor pool = (ThreadPoolExecutor)newFixedThreadPool(5);
        while (true) {
//            Thread.sleep(200);
            System.out.println("Enter a number or 'EXIT' to exit ");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("EXIT")) break;
            try {
                long number = Long.parseLong(line);
                if (pool.getActiveCount() < pool.getMaximumPoolSize()) {
                    Callable<Void> task = () -> {
                        findNthPrime(number);
                        return null;
                    };
                    pool.submit(task);
//                    System.out.println("Pool active count: "+pool.getActiveCount());
//                    System.out.println("Pool maximum size: "+pool.getMaximumPoolSize());
                }else System.out.println("No free thread. Try again.");
            } catch (NumberFormatException e) {
                System.out.println(line + " Incorrect number format");
            }
        }
        pool.shutdown();
        scanner.close();
    }
    public static boolean checkPrime(long n) {
        for (long i=2; i<=Math.sqrt(n); i++){
            if (n%i==0)return false;
        }return true;
    }

    public static void findNthPrime(long n){
                long i = 3;
                long count = 1;
                if (n == 1) System.out.println(n + "th Prime number is " + 2);
                else if (n <= 0) System.out.println(n + "th prime number doesn't exist!");
                else {
                    while (true) {
                        if (checkPrime(i)) count += 1;
                        if (count == n) break;
                        i++;
                    }
                    System.out.println(n + "th Prime number is " + i);
                }
        }
}