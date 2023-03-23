package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        int movesLeft = 9;

        initializeBoard(board);
        printBoard(board);

        while (movesLeft > 0) {
            System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
            int row = scanner.nextInt() - 1; // subtract 1 to convert to array index
            int col = scanner.nextInt() - 1;

            if (makeMove(board, row, col, currentPlayer)) {
                printBoard(board);
                if (checkWin(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }

            movesLeft--;
        }

        if (movesLeft == 0) {
            System.out.println("Game over. It's a tie!");
        }

        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean makeMove(char[][] board, int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        board[row][col] = player;
        return true;
    }

    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}