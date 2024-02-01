// https://codeforces.com/problemset/problem/300/A

import java.util.ArrayList;
import java.util.Scanner;

public class CfArray300A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findArraySet(arr, n);
        sc.close();
    }

    static void findArraySet(int arr[], int n) {
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else if (arr[i] < 0) {
                neg.add(arr[i]);
            } else {
                zero.add(arr[i]);
            }
        }

        if (pos.size() == 0) {
            pos.add(neg.get(neg.size() - 1));
            neg.remove(neg.size() - 1);
            pos.add(neg.get(neg.size() - 1));
            neg.remove(neg.size() - 1);
        }

        System.out.println(1 + " " + neg.get(0));

        System.out.print(pos.size() + " ");
        for (int i = 0; i < pos.size(); i++) {
            System.out.print(pos.get(i) + " ");
        }
        System.out.println();

        System.out.print((neg.size() - 1) + zero.size() + " ");
        for (int i = 1; i < neg.size(); i++) {
            System.out.print(neg.get(i) + " ");
        }

        for (int i = 0; i < zero.size(); i++) {
            System.out.print(zero.get(i) + " ");
        }
    }
}
/*
 * In this problem it is given that solution always exits so,
For negative product we can just print a single negative element so its product is always negative.
For positive element we can  print all positive element so its product is always positive and if
 there is no positive element then we can print two negative element ,product of two negative element is
  positive.
For zero procduct print rest of element.
 */