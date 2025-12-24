package com.manulife.hk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class SortService {

    public int[] quickSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return arr;
        }
        this.quickSort(arr, 0, arr.length -1);
        return arr;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivotIndex = left + new Random().nextInt(right - left + 1);
        swap(arr, left, pivotIndex);
        int pivot = arr[left];

        int leftPtr = left;
        int rightPtr = right;
        while(leftPtr < rightPtr) {
            while(leftPtr < rightPtr && arr[rightPtr] >= pivot) {
                rightPtr--;
            }
            while(leftPtr < rightPtr && arr[leftPtr] <= pivot) {
                leftPtr++;
            }

            swap(arr, leftPtr, rightPtr);
        }

        swap(arr, left, leftPtr);

        quickSort(arr, left, leftPtr - 1);
        quickSort(arr, leftPtr + 1, right);
    }
}
