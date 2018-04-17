/*
 * Java Program to Implement Heap Sort
 */

import java.util.Scanner;

/* Class HeapSort */
class HeapSort
{
    private static int N;

    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /* Function to swap largest element in heap */
    public static void maxheap(int arr[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;

        if (left <= N && arr[left] > arr[i])
            max = left;

        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    /* Function to build a heap */
    public static void heapify(int arr[])
    {
        N = arr.length-1;

        for (int i = N/2; i >= 1; i--)
            maxheap(arr, i);
    }

    /* Sort Function */
    public static void sort(int arr[])
    {
        heapify(arr);
        for (int i = N; i > 0; i--)
        {
            swap(arr,1, i);
            N = N-1;
            maxheap(arr, 1);
        }
    }



    /* Main method */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Heap Sort Test\n");
        int n, i;

        /* Accept number of elements */
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        n++;
        /* Make array of n elements */
        int arr[] = new int[ n ];

        arr[0] = n-1;
        /* Accept elements */
        System.out.println("\nEnter "+ arr[0] +" integer elements");
        for (i = 1; i < n; i++)
            arr[i] = scan.nextInt();

        /* Call method sort */
        sort(arr);

        /* Print sorted Array */
        System.out.println("\nElements after sorting :");
        for (i = 1; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.println();
    }
}
