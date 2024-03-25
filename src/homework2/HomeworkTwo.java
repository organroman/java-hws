package homework2;

import homework1.HomeworkOne;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkTwo {
    static char[][] generateInitialBoard(int x, int y) {
        char[][] xss = new char[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                xss[i][j] = '-';
            }
        }

        return xss;
    }

    static String showRow(char[] xs, int rowNumber) {
        StringBuilder outcome = new StringBuilder();
        String rowNumberStr = Integer.toString(rowNumber);
        outcome.append(rowNumberStr);
        outcome.append(" | ");

        for (int idx = 0; idx < xs.length; idx++) {
            char x = xs[idx];
            outcome.append(x);
            outcome.append(" | ");
        }

        return outcome.toString();
    }

    static String showHeaderOfBoard(char[] xs) {
        StringBuilder outcome = new StringBuilder();
        for (int idx = 0; idx < xs.length; idx++) {
            String x = Integer.toString(idx);
            outcome.append(x);
            outcome.append(" | ");

        }
        String lastEl = Integer.toString(xs.length);
        outcome.append(lastEl);
        outcome.append(" |");

        return outcome.toString();
    }

    static String renderBoard(char[][] arr) {
        StringBuilder outcome = new StringBuilder();
        outcome.append(showHeaderOfBoard(arr[0]));

        for (int idx = 0; idx < arr.length; idx++) {
            char[] xs = arr[idx];
            String x1 = showRow(xs, idx + 1);
            outcome
                    .append("\n")
                    .append(x1);
        }
        return outcome.toString();
    }

    static int randomNumber(int maxNum) {
        return (int) (Math.random() * maxNum + 1);
    }

    static int validateAndParseIntUserNum(int maxNum) {
        Scanner scanner = new Scanner(System.in);
        int userNum = 0;
        String userEnter;

        do {
            userEnter = scanner.next();
            if (!HomeworkOne.isANumber(userEnter)) {
                System.out.print("It's not a valid number. Enter again: ");
                continue;
            }
            userNum = Integer.parseInt(userEnter);
            if (userNum < 1 || userNum > maxNum) {
                System.out.printf("Number out of range. Enter a number between 1 and %s: ", maxNum);
            }
        } while (!HomeworkOne.isANumber(userEnter) || userNum < 1 || userNum > maxNum);

        return Integer.parseInt(userEnter);
    }

    static int[] getUserNumbers(int maxX, int maxY) {

        System.out.printf("Enter the row number (1-%d) you would like to hit: ", maxX);
        int userX = validateAndParseIntUserNum(maxX);
        System.out.printf("Enter the column number (1-%d) you would like to hit: ", maxY);
        int userY = validateAndParseIntUserNum(maxY);

        return new int[]{userX, userY};
    }

    static int defineBoardSize(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String sizeStr = scanner.next();
        int sizeInt;

        while (!HomeworkOne.isANumber(sizeStr)) {
            System.out.print("It's not valid number, enter again: ");
            sizeStr = scanner.next();
        }
        sizeInt = Integer.parseInt(sizeStr);

        return sizeInt;
    }

    static void updateBoard(int cx, int cy, char[][] initialBoard) {
        int[] userCoors;

        // define the size of initial board which user is created
        int xLength = initialBoard.length;
        int yLength = initialBoard[0].length;

        do {
            userCoors = getUserNumbers(xLength, yLength); // pass board size in order to properly define maxUser numbers in game
            char[][] updatedBoard = Arrays.copyOf(initialBoard, initialBoard.length);

            if (userCoors[0] != cx | userCoors[1] != cy) {
                updatedBoard[userCoors[0] - 1][userCoors[1] - 1] = '*';
                System.out.println(renderBoard(updatedBoard));
            } else {
                updatedBoard[userCoors[0] - 1][userCoors[1] - 1] = 'X';
                System.out.println(renderBoard(updatedBoard));
                System.out.println("You win");
                break;
            }
        } while (cx != userCoors[0] | cy != userCoors[1]);
    }

    static void startGame() {
        System.out.println("Firstly, let define a size of our board. I would recommend 5x5!");
        int sizeX = defineBoardSize("Enter the number of rows: ");
        int sizeY = defineBoardSize("Enter the number of columns: ");

        char[][] initialBoard = generateInitialBoard(sizeX, sizeY);
        System.out.println("All Set. Get ready to rumble!");
        System.out.println(renderBoard(initialBoard));
        int coorsX = randomNumber(sizeX);
        int coorsY = randomNumber(sizeY);

        updateBoard(coorsX, coorsY, initialBoard);
    }

    public static void main(String[] args) {
        startGame();
    }
}
