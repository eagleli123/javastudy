package com.example.demo.name;

import java.util.Arrays;

/**
 * @author: lihui
 * @date: 2020-07-20
 */
public class NameMain {
    public static void main(String[] args) {
        char[] chars = {'木', '子', '光', '军'};
        paiLie(chars, 0);
    }

    public static void paiLie(char[] arr, int index) {
        if (index == arr.length - 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == '木' && arr[i + 1] == '子' && (i == 0 || i == 2)) {
                    return;
                }
                if (arr[i] == '光' && arr[i + 1] == '军' && (i == 0 || i == 2)) {
                    return;
                }
                if (arr[i] == '木' && arr[i + 1] == '军' && (i == 0 || i == 2)) {
                    return;
                }
                if (arr[i] == '军' && arr[i + 1] == '子' && (i == 0 || i == 2)) {
                    return;
                }
                if (arr[i] == '木' && arr[i + 1] == '光' && (i == 0 || i == 2)) {
                    return;
                }
                if (arr[i] == '光' && arr[i + 1] == '子' && (i == 0 || i == 2)) {
                    return;
                }
            }
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                paiLie(arr, index + 1);
                swap(arr, index, i);
            }
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
