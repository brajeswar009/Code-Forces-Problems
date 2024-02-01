// https://codeforces.com/problemset/problem/1656/A

import java.util.Scanner;

public class CfGoodPairs1656A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            findGoodPairs(arr, n);
        }
        sc.close();
    }

    static void findGoodPairs(int arr[], int n) {
        int min = arr[0], minIndex = 0;
        int max = 0, maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }

        }
        System.out.println((minIndex + 1) + " " + (maxIndex + 1));
    }
}
//logic used:-
/*If we solve the equation |ai-ak|+|ak-aj|=|ai-aj|
 * if we open the mod with '+' then the res will be ai-aj (both ak will cancel each other) so we can say 
 * ai> ak and ak> aj i.e (aj<ak<ai)
 * or, if we open the mod with '-' sign the the res will be aj-ai(both ak will cancel each other) so we
 * will get ak>ai annd aj>ak i.e.(ai<ak<aj)
 * so in both the cases ak comes between ai and aj so if we take minimum element of the array as 
 * ai then ak will definitely be bigger than ai and aj as biggest element of array then ak will definitely
 * be smaller than aj.
 */

/*
 * BruteForce Approach:-
 * ArrayList<Integer> pairs = new ArrayList<Integer>();
 * int i = 0;
 * int j = 0;
 * int k = 0;
 * boolean test = false;
 * for (i = 0; i < arr.length; i++) {
 * if (test == true && (k == n - 1)) {
 * break;
 * }
 * for (j = 0; j < arr.length; j++) {
 * if (test == true && (k == n - 1)) {
 * break;
 * }
 * for (k = 0; k < arr.length; k++) {
 * if (Math.abs(arr[i] - arr[k]) + Math.abs(arr[k] - arr[j]) == Math.abs(arr[i]
 * - arr[j])) {
 * test = true;
 * continue;
 * } else {
 * test = false;
 * break;
 * }
 * }
 * }
 * }
 * pairs.add(i);
 * pairs.add(j);
 * System.out.println(pairs);
 * 
 */