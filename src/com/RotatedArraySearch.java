package com;

public class RotatedArraySearch {

        public static int search(int[] arr, int n) {
            int left = 0;
            int right = arr.length - 1;

            while(left <= right) {

                int middle = left + (right - left) / 2;
                if(arr[middle] == n) {
                    return middle;
                }
                else if(arr[left] < arr[middle]) {
                    //THis loop is for the case where the left half of the array is sorted
                    if(arr[middle] > n && arr[left] <= n) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else if(arr[middle] < arr[right] ) {
                    //THis loop is for the case where the right half of the array is sorted
                    if(arr[middle] < n && arr[right] >= n) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else if(arr[left] == arr[middle] ) {
                    if(arr[middle] != arr[right]) {
                        left = middle + 1;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }

        public static void main(String args[]) {
            int []arr = {4,5,6,7,0,1,2};
            int []arr2 = {1};
            System.out.print(search(arr, 0));
            System.out.print(search(arr, 3));
            System.out.print(search(arr2, 0));
        }
}
