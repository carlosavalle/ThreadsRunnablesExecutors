package com.company;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
// implemented Runnable
public class Student implements Runnable{

    private int Id;
    private String Name;
    private int sleep;
    private AtomicInteger atomicInteger;

    public Student(String name, AtomicInteger atomicInteger) {
        // validate the value  if it valid, it will store it. If not, it will throw and exception
        if(!Validators.isValidateName(name)){
            throw new IllegalArgumentException("Enter a valid name");
        }
        Name = name;
        this.atomicInteger = atomicInteger;
        Random random = new Random();
        sleep = random.nextInt(100);
    }

    @Override
    public void run() {
        if(sleep > 0){
            try {
                // shows the sleep time that the Thread will have
                System.out.println("ID " + Id + ", Name "+ Name + ", Sleep time " + sleep);
                // will sleep the thread
                Thread.sleep(sleep);
                //get the Atomic variable
                int AuxID= atomicInteger.incrementAndGet();
                // validate the value  if it valid, it will store it. If not, it will throw and exception
                if(!Validators.isValidateID(AuxID)){
                    throw new IllegalArgumentException("Enter a valid ID");
                }
               // will assign the id value
                Id =AuxID;

            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("ID " + Id + ", Name "+ Name + ", Sleep time done");

    }
}
