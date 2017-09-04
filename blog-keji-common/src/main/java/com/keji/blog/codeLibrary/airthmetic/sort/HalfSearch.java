package com.keji.blog.codeLibrary.airthmetic.sort;

/**
 * Created by wb-ny291824 on 2017/8/19.
 * 二分查找
 * 为了提高查找效率，可使用折半查找的方式，注意：这种查找只对有序的数组有效。
 3     这种方式也成为二分查找法
 */
public class HalfSearch {
    public static void main(String[] args) {

    }

    public static int halfSearch(int[] arr, int key) {
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid+1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }

            if (min > max) {
                return -1;
            }
            mid = (max+min)/2;
        }
        return mid;

    }
}
