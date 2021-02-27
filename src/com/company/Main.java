package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        // it is the Atomic variable that I use to assign student's id
        AtomicInteger atomicInteger = new AtomicInteger();
        //the executor
        ExecutorService executorService = Executors.newFixedThreadPool(7);


        try {
            // I instantiate the new students
            Student student1 = new Student("Carlos",atomicInteger);
            Student student2 = new Student("Esteban",atomicInteger);
            Student student3 = new Student("Eduardo",atomicInteger);
            Student student4 = new Student("Cristina",atomicInteger);
            Student student5 = new Student("Romina",atomicInteger);
            Student student6 = new Student("Aaron",atomicInteger);
            Student student7 = new Student("Adam",atomicInteger);

            //I executed thew new students
            executorService.execute(student1);
            executorService.execute(student2);
            executorService.execute(student3);
            executorService.execute(student4);
            executorService.execute(student5);
            executorService.execute(student6);
            executorService.execute(student7);
            //stops the executor
            executorService.shutdown();
        }catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
