package amazon;

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    void linkdelete(Node head, int M, int N) {
        // your code here
        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count == M) {
                int del = 0;
                while (del < N && temp.next != null) {
                    temp.next = temp.next.next;
                    del++;
                }
                count = 0;
            }
            temp = temp.next;
            count++;
        }
    }
}

public class LinkedListDelete {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int listSize = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");

            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);

            Node head = null;
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            new Solution().linkdelete(head, m, n);
            printList(head);
            System.out.println();
        }
    }
}
