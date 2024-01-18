package boj_10989_수정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

    // l=start, m=middle, r=end
    public static void merge(int arr[], int l, int m, int r) {

        //Find sizes of two sub
        int n1=m-l+1;
        int n2=r-m;

        //create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Copy data to temp arrays
        for (int i=0; i<n1; i++) L[i]=arr[l+i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];


        //Initial indices of first and second subarrays
        int i=0, j=0;

        // Initial index of merged subarray array
        int k=l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }//merge

    void sort(int arr[], int l, int r) {
        if (l < r) {

            // Find the middle point
            int m=l+(r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr,l,m,r);
        }
    }

    public static void main(String[] args) throws IOException {
        int N;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        MergeSort ob=new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}