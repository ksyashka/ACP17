package testtask.cyber;

import java.util.Arrays;

public class TestTask {
    static String sumString(String a, String b){
        int valueA = Integer.valueOf(a);//Integer.parseInt(a);
        int valueB = Integer.valueOf(b);
        int result = valueA+valueB;
        return String.valueOf(result);//Integer.toString(result);
    }

    static int maxCountSequence(int ... numbers){
        int count=1, countMax=1;
        for (int i=1; i<numbers.length;i++){
            if (numbers[i]>numbers[i-1]) {
                count++;
                if (count > countMax) countMax = count;
            }
            else count=1;
        }
        return countMax;
    }

    static void showRandom(int number){
        int[] numbers = new int[number];
        for (int i=0;i<number;i++)
            numbers[i]=i+1;

        for (int i=0;i<number;i++)
            for(int j=1;j<number;j++) {
                System.out.println(Arrays.toString(numbers));
                int temp=numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=temp;
            }

    }

    static void order(int ... numbers){
       // Arrays.sort(numbers);
        for (int i=0; i<numbers.length;i++)
            for (int j=0; j<numbers.length;j++)
                if(numbers[j]>numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
        System.out.println(Arrays.toString(numbers));
    }

    static int min(int[] a, int k){
        return 0;
    }

    static boolean contains(int[] a, int value){
        return false;
    }

    static void printSum(int[] a, int sum){

    }

    static void printMatrix(int n){
        if (n == 0) System.exit(0);
        for (int i=0;i<n;i++){
            printStars(n-i);
            System.out.print(i+1);
            printStars(n-i);
            System.out.println();
    }
}

    private static void printStars(int n) {
        for (int i=0;i<n-1;i++)
        System.out.print("*");
    }
    }
