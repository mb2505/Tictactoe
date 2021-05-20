import java.util.Scanner;
import java.util.ArrayList;

public class Tictactoe {

    public static char[][] arr = new char[3][3];
    public static boolean xWins = false;
    public static boolean oWins = false;
    public static int countX = 0;
    public static int countY = 0;
    public static int firstNumber;
    public static int secondNumber;
    public static int update = 0;
    public static int check;

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ' ';
                count++;
            }
        }

        printTable();

        while (!xWins && !oWins && check != 9) {
            enterNumbers();
            updateTable();
            printTable();
            analyzeGame();
            result();
        }
    }

    public static void printTable() {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", arr[0][0], arr[0][1], arr[0][2]);
        System.out.printf("| %c %c %c |\n", arr[1][0], arr[1][1], arr[1][2]);
        System.out.printf("| %c %c %c |\n", arr[2][0], arr[2][1], arr[2][2]);
        System.out.println("---------");
    }

    public static void analyzeGame() {
        if (arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X') {
            xWins = true;
        } else if (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X') {
            xWins = true;
        } else if (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X') {
            xWins = true;
        } else if (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X') {
            xWins = true;
        } else if (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X') {
            xWins = true;
        } else if (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X') {
            xWins = true;
        } else if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
            xWins = true;
        } else if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
            xWins = true;
        }

        if (arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O') {
            oWins = true;
        } else if (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O') {
            oWins = true;
        } else if (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O') {
            oWins = true;
        } else if (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O') {
            oWins = true;
        } else if (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O') {
            oWins = true;
        } else if (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O') {
            oWins = true;
        } else if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
            oWins = true;
        } else if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
            oWins = true;
        }
    }

    public static void count() {
        countX = 0;
        countY = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 'X') {
                    countX++;
                } else if (arr[i][j] == 'O') {
                    countY++;
                }
            }
        }
    }

    public static void result() {
        check = countX + countY;

        if (Math.abs(countX - countY) > 1) {
            System.out.println("Impossible");
        }  else if (!xWins && !oWins && check == 9) {
            System.out.println("Draw");
        } else if (xWins && !oWins) {
            System.out.println("X wins");
        } else if (!xWins && oWins) {
            System.out.println("O wins");
        }
    }

    public static void enterNumbers() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the coordinates:");
        try {
            firstNumber = s.nextInt();
            secondNumber = s.nextInt();
            analyze();
        } catch (Exception e) {
            enterNumbers();
        }
    }

    public static void analyze() {
        if (firstNumber < 1 || secondNumber < 1 || firstNumber > 3 || secondNumber > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            enterNumbers();
        }

        if (arr[firstNumber - 1][secondNumber - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            enterNumbers();
        }
    }

    public static void updateTable() {
        if (update % 2 == 0) {
            arr[firstNumber - 1][secondNumber - 1] = 'X';
            count();
            update++;
        } else {
            arr[firstNumber - 1][secondNumber - 1] = 'O';
            count();
            update++;
        }
    }
}