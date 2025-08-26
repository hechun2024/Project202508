import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Enter size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Enter elements of array
        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        //print the original array
        System.out.println("\nThe original array:");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }

        // remove duplicates
        int[] newArr = new int[n];  // 新数组，长度和原数组一样（可能不会完全填满）
        int newSize = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false; //未发现重复
            for (int j = 0; j < newSize; j++) {
                if (arr[i] == newArr[j]) {
                    found = true;
                    break;
                }
            }
            // if no duplicates, add all elements to new array
            if (!found) {
                newArr[newSize] = arr[i];
                newSize++;
            }
        }

        // print new array
        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < newSize; i++) {
            System.out.print(newArr[i] + " ");
        }

        scanner.close();
    }
}
