package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.lang.Thread.currentThread;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long n = scanner.nextLong();

        Callable<Long> task = ()-> {
            return findNthPrime(n);
        };
        Future<Long> future = executorService.submit(task);
        executorService.shutdown();
//        System.out.println("Inside main: "+currentThread().getName());
        long result = future.get();
        if (result==0L) System.out.println(n+"th prime number doesn't exist!");
        else System.out.println(n + "th Prime number is " + result);

//        List number = Arrays.asList(2,3,4,5);
//        System.out.println("Average: "+ calculateAverage(number));
//
//        List words = Arrays.asList("hfdh", "vdhgEXEMK", "BFHEXheE");
//        System.out.println("Listed words: "+ findSubStringWords("EXE", words));
    }

    public static float calculateAverage(List<Integer> numbers) {
        return numbers.stream().reduce(0,(ans,i)->ans+i)/numbers.size();
    }

    public static List<String> findSubStringWords(String s, List<String> words) {
        return words.stream().filter(w->w.contains(s)).collect(Collectors.toList());
    }

    public static boolean checkPrime(long n) {
        for (long i=2; i<=Math.sqrt(n); i++){
            if (n%i==0)return false;
        }return true;
    }

    public static long findNthPrime(long n) {
            long i = 3;
            long count = 1;
            if (n==1)return 2L;
            if (n<=0)return 0L;
            while (true) {
                if (checkPrime(i)) count += 1;
                if (count == n) break;
                i++;
            }
//        System.out.println("Outside main: "+currentThread().getName());
//            try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            return i;

    }

}