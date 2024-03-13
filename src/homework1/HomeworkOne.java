package homework1;

import java.util.Arrays;
import java.util.Scanner;


public class HomeworkOne {
    // get one random number
    public static int RandomNumber() {
        return (int) (Math.random() * 100 + 1);
    }

    // check if the user typed a number
    public static boolean isANumber(String str) {
        return str.matches("-?(0|[1-9]\\d*)");
    }

    // add element to array
    public static int[] addElementToArray(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = element;
        return newArray;
    }

    // array to string
    static String show(int[] arr) {
        StringBuilder outcome = new StringBuilder("[");
        for (int idx = 0; idx < arr.length; idx++) {
            int x = arr[idx];
            String x1 = Integer.toString(x);
            if (idx > 0) outcome.append(", ");
            outcome.append(x1);
        }
        return outcome.append("]").toString();
    }

    // sort numbers in descending order
    static int[] sorting(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < sortedArr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < sortedArr.length; j++) {
                if (sortedArr[j] > sortedArr[i]) {
                    maxIdx = j;
                }
            }
            int tmp = sortedArr[i];
            sortedArr[i] = sortedArr[maxIdx];
            sortedArr[maxIdx] = tmp;

        }

        return sortedArr;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        String playerName = scanner.next();

        System.out.println("Lets the game begin!");
        int computerNumber = RandomNumber();

        System.out.println("I've got a number from 1 to 100. Try to guess it");
        int[] playerNumbers = new int[0];
        int playerNumber;

        do {
            System.out.print("Enter your number here ");
            String playerEnter = scanner.next();

            while (!isANumber(playerEnter)) {
                System.out.print("It's not a number, enter again: ");
                playerEnter = scanner.next();
            }

            playerNumber = Integer.parseInt(playerEnter);

            playerNumbers = addElementToArray(playerNumbers, playerNumber);
            playerNumbers = sorting(playerNumbers);


            if (playerNumber > computerNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else if (playerNumber < computerNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.printf("Congratulation, %s, you win!", playerName);
                System.out.println();
                System.out.printf("Your numbers: %s", show(playerNumbers));
            }
        } while (playerNumber != computerNumber);
    }
}
