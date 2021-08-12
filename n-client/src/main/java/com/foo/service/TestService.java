package com.foo.service;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

/**
 * @author: he
 * @date: 2019/4/19
 */
public class TestService {


    public void testMethod(){
        SoftReference<Object> softReference = new SoftReference<>(new Object());
    }


    @Data
    public static class Node implements Serializable {
        private static final long serialVersionUID = -4834331000879511352L;
        Integer data;
        Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

    }


    public static class LinkList {
        int size;
        Node head;
        Node first;
        Node tail;


        public LinkList(int n) {
            this.size = n;
            this.head = new Node(null, null);
            for (int i= 1; i<= n; i++) {
                Node node = new Node(i, null);
                if (first == null) {
                    first = node;
                    tail = node;
                    head = new Node(null, first);
                } else {
                    tail.next = node;
                    tail = node;
                }
                tail.next = head;
            }
        }

        public void remove(Node parentNode, Node node) {
            if (parentNode == node) {
                size = 1;
                return;
            }
            if (head.next == node) {
                head.next = node.next;
                first.next = node.next;
            }
            parentNode.next = node.next;
            size--;
        }


        public int getSize() {
            return size;
        }


        public void printList() {
            if (size == 0) {
                return;
            }
            Node tempNode = head;
            while (tempNode.next != head) {
                tempNode = tempNode.next;
                System.out.println(tempNode.data);
            }
        }
    }


    public static class print implements Runnable {
        String content;
        Semaphore semaphore;
        Semaphore selfSemaphore;
        Integer count;

        public print(String content, Semaphore semaphore,
                     Semaphore selfSemaphore,
                     Integer count) {
            this.content = content;
            this.semaphore = semaphore;
            this.selfSemaphore = selfSemaphore;
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println("thread +" + content + "start");
            while (count > 0) {
                if (selfSemaphore.tryAcquire()) {
                    System.out.println(content);
                    count--;
                    semaphore.release(1);
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        LinkList myList = new LinkList(10);
//
//        int m = 3;
//        Node pointer = myList.head;
//        Node parentPointer = myList.head;
//        while (myList.size > m) {
//            for (int i = 0; i< m; i++) {
//                if (i < m - 1) {
//                    parentPointer = pointer.next;
//                }
//                pointer = pointer.next;
//
//                if (i == m - 1) {
//                    myList.remove(parentPointer, pointer);
//                }
//            }
//
//        }
//
//        myList.printList();

        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        Integer count = 10;
        Thread c = new Thread(new print("C", semaphoreA, semaphoreC, count));
        Thread b = new Thread(new print("B", semaphoreC, semaphoreB, count));
        Thread a = new Thread(new print("A", semaphoreB, semaphoreA, count));

        c.start();
        Thread.sleep(2000);
        b.start();
        Thread.sleep(2000);
        a.start();
        Thread.sleep(1000);

        semaphoreA.release(1);
    }
}
