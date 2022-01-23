package intuit;

import java.util.*;

class Mountain {
    int[] arr;

    Mountain(int[] arr) {
        this.arr = arr;
    }

    int length() {
        return this.arr.length;
    }

    int get(int index) {
        return this.arr[index];
    }
}

class Solution {
    public static int findPeek(Mountain arr) {
        int low = 0, high = arr.length() - 1, peek = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int x = arr.get(mid), y = x - 1, z = x + 1;
            if (mid > 0) {
                y = arr.get(mid - 1);
            }
            if (mid < arr.length() - 1) {
                z = arr.get(mid + 1);
            }
            if (x > y && x > z) {
                peek = mid;
                break;
            } else if (x > y && x < z) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return peek;
    }

    public static int binarySearch(Mountain arr, int target, boolean isReverse, int low, int high) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int x = arr.get(mid);
            if (x == target) {
                ans = mid;
                break;
            } else if (x > target) {
                if (isReverse) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (isReverse) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return ans;
    }

    public int findInMountainArray(int target, Mountain arr) {
        int peek = findPeek(arr);
        int ans = -1;
        ans = binarySearch(arr, target, false, 0, peek);
        if (ans == -1) {
            ans = binarySearch(arr, target, true, peek + 1, arr.length() - 1);
        }
        return ans;
    }
}

public class MountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Mountain mntn = new Mountain(arr);
        System.out.println(mntn.arr);
        sc.close();
    }
}
