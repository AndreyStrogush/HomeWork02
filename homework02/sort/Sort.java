package homework02.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sort {

    //create an array, in this case a predetermined size
    public static int[] create() {
        int n = 1000000;
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n);
        }
        return array;
    }

    public static void measure() {
        int[] numbers = Sort.create();              // create an array
        int[] numbers2  = new int[numbers.length];  // copy  of array
        int low = 0, high = numbers.length - 1;     //values for some sorts - 1st and last elements
        Scanner sc = new Scanner(System.in);        //scanner to choose sorting method
        //create copy of array
        System.arraycopy(numbers, 0, numbers2, 0, numbers.length);

        System.out.println("Choose sorting metod: \n" +
                "\t 1. Quick sort \n" +
                "\t 2. Merge sort \n" +
                "\t 3. Heap sort \n" +
                "\t 4. Bubble sort \n" +
                "\t 5. Shell sort \n" +
                "\t 6. Selection sort \n" +
                "\t 7. Bucket sort \n" +
                "\t 8. Radix sort \n");
        int n = sc.nextInt();

        long startTime = System.currentTimeMillis();            // the start of execution
        switch (n) {
            //      1. Quick sort
            case 1:
                System.out.println("Quick sort: ");         //165 ms
                Sort.quickSort(numbers2, low, high);
                break;
            //      2. Merge sort
            case 2:
                System.out.println("Merge sort: ");       //312 ms
                Sort.mergeSort(numbers2, low, high);
                break;
            //      3. Heap sort
            case 3:
                System.out.println("Heap sort: ");   //234 ms
                Sort.heapSort(numbers2);
                break;
            //  4. Bubble sort
            case 4:
                System.out.println("Bubble sort: ");     // ???
                Sort.bubbleSort(numbers2);
                break;

            // 5. Shell sort
            case 5:
                System.out.println("Shell sort: ");      //298 ms
                Sort.shellSort(numbers2);
                break;
            // 6. Selection sort
            case 6:
                System.out.println("Selection sort: ");         //64 ms
                Sort.sort(numbers2, numbers2.length);
                break;
            // 7. Bucket sort
            case 7:
                System.out.println("Bucket sort: ");         //31 ms
                Sort.bucketSort(numbers2);
                break;
            // 8. Radix sort
            case 8:
                System.out.println("Radix sort: ");     //607 ms
                Sort.radixSort(numbers2);
                break;
            default:
                System.out.println("Wrong input");
                break;
        }

        long endTime = System.currentTimeMillis();                  //end of sorting

        System.out.println("Time of sort is: "
                + (endTime - startTime) + " ms");                   //display the time spent in milliseconds
        System.out.println("Initial array: \n");                    //check how sorting worked
        Sort.printArray(numbers,40);
        System.out.println("\nArray after sorting: \n");
        Sort.printArray(numbers2, 40);
    }

    //sort algorithms

    //      1. Quick sort
    public static int[] quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int dp = partition(numbers, low, high);
            quickSort(numbers, low, dp - 1);
            quickSort(numbers, dp + 1, high);
        }
        return numbers;
    } //end quickSort

    //      2. marge sort
    public static int[] mergeSort(int[] numbers, int low, int high) {
        if (low < high) { // list contains at least 2 elements
            int mid = (low + high) / 2;
            mergeSort(numbers, low, mid); // recursion : sort first half
            mergeSort(numbers, mid + 1, high); // recursion : sort second half
            merge(numbers, low, mid, high); // merge both sorted halves
        }
        return numbers;
    } // end margeSort

    //      3. heap sort
    public static int[] heapSort(int[] numbers) {
        for (int i = numbers.length / 2 - 1; i >= 0; i--) {
            // convert the array to a heap
            shiftDown(numbers, i, numbers.length);
        }
        for (int i = numbers.length - 1; i > 0; i--) {
            swap(numbers, 0, i); /* deleteMax */
            shiftDown(numbers, 0, i);
        }
        return numbers;
    } // end heapSort

    //      4. bubble sort
    public static int[] bubbleSort(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                //swap elements
                if (numbers[j - 1] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }
        return numbers;
    }//end bubbleSort

    //      5. shell sort
    public static int[] shellSort(int[] numbers) {
        int j;
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                int temp = numbers[i];
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
                    numbers[j] = numbers[j - gap];
                }
                numbers[j] = temp;
            }
        }
        return numbers;
    }//end shellSort

    //      6. selection sort
    public static int[] sort(int[] numbers, int n) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {

            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        int range = max - min + 1;

        int[] count = new int[range];

        //counts frequencies for each element

        for (int i = 0; i < n; i++) {
            count[numbers[i] - min]++;
        }
        // getting positions in final array

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //copy to output array, preserving order of inputs with equal keys
        int j = 0;

        for (int i = 0; i < range; i++) {

            while (j < count[i])

                numbers[j++] = i + min;
        }
        return numbers;
    }//end sort

    //      7. bucket sort
    public static int[] bucketSort(int[] numbers) {
        int i;
        int j;
        int[] bucket = new int[numbers.length + 1];

        Arrays.fill(bucket, 0);

        for (i = 0; i < numbers.length; i++) {
            bucket[numbers[i]]++;
        }

        int k = 0;
        for (i = 0; i < bucket.length; i++) {
            for (j = 0; j < bucket[i]; j++) {
                numbers[k++] = i;
            }
        }
        return numbers;
    }//end bucketSort

    //      8. radix sort
    public static int[] radixSort(int[] numbers) {
        final int DIV = 10;
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // sort
        boolean flag = false;
        int tmp = -1, divisor = 1;
        while (!flag) {
            flag = true;
            // split input between lists
            for (Integer i : numbers) {
                tmp = i / divisor;
                buckets[tmp % DIV].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < DIV; b++) {
                for (Integer i : buckets[b]) {
                    numbers[a++] = i;
                }
                buckets[b].clear();
            }
            // move to next digit
            divisor *= DIV;
        }
        return numbers;
    }//end radixSort

    // additional methods

    // partition numbers[low] to numbers[high] using numbers[low] as the pivot
    private static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int i = low;
        for (int j = low + 1; j <= high; j++)
            if (numbers[j] < pivot) {
                ++i;
                swap(numbers, i, j);
            }
        //end for
        swap(numbers, low, i);
        return i;
    }//end partition

    //     Merge sorted array of elements from low to mid and mid+1
    //      low is the left most position of the subset of elements
    //      high is the right most position of the subset of elements
    private static void merge(int[] subset, int low, int mid, int high) {

        int n = high - low + 1;
        int[] temp = new int[n];

        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid) {
                temp[k++] = subset[j++];
            } else if (j > high) {
                temp[k++] = subset[i++];
            } else if (subset[i] < subset[j]) {
                temp[k++] = subset[i++];
            } else {
                temp[k++] = subset[j++];
            }
        }
        for (j = 0; j < n; j++)
            subset[low + j] = temp[j];
    } // end merge

    // Exchange list[i] and list[j] values
    // (swap numbers)
    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    // for heapSort
    private static void shiftDown(int[] a, int i, int n) {
        int child;
        int tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && (a[child] < a[child + 1])) {
                child++;
            }
            if (tmp < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }//end shiftDown

    // for heapSort
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static void printArray(int[] numbers, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + "; ");
        }
        if (n < numbers.length) {
            System.out.println("...");
        }
    }
}
