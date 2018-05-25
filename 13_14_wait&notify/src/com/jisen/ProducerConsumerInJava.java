package com.jisen;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by jisen on 2018/4/10.
 */
public class ProducerConsumerInJava {

    class Person{

    }

    static class Producer extends Thread{
        private Queue queue;
        private int maxSize;
        public Producer(Queue queue, int maxSize, String name){
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            int i = 1;
              while(true){
                  synchronized (queue){
                      while(queue.size()==maxSize) {
                          try {
                              System.out.println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                              queue.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }

                      /*Random random = new Random();
                      int i = random.nextInt();*/
                      System.out.println("Producing value :" + i);
                      queue.add(i++);
                      queue.notifyAll();//唤醒其他线程
                  }
              }
        }
    }

    static class Consumer extends Thread{
        private Queue queue;
        private int maxSize;
        public Consumer(Queue queue, int maxSize,String name){
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while(queue.isEmpty()){
                        try {
                            System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("Consumer value: "+queue.remove());
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("How to wait and notify method in Java");
        System.out.println("solving Producer Consumer Problem");
        Queue buffer = new LinkedList();
        int maxSize = 10;
        Thread producer = new Producer(buffer, maxSize,"Producer");
        Thread consumer = new Consumer(buffer, maxSize,"Producer");
        producer.start();
        consumer.start();

    }
}
