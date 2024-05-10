package org.example;

import java.util.Scanner;

enum Player {
    FIRST,
    SECOND
}

public class Loop {
    private final Board board = new Board();
    private Player player;
    private int nTurn = 0;

    public void start() {
        while (nTurn < 9) {
            printBoard();
            manageTurn();
            setSelectedCell(getUserInput());
            checkWinner();
        }
        endGame();
    }

    private void manageTurn() {
        if (player == null || player == Player.SECOND) {
            player = Player.FIRST;
        } else {
            player = Player.SECOND;
        }

        nTurn++;
    }

    private int getUserInput() {
        System.out.println("Enter cell number: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 1 || input > 9) {
            System.out.println("Invalid number. Please enter a valid cell number: ");
            input = scanner.nextInt();
        }
        return input;
    }

    private void setSelectedCell(int input) {
        board.setCell(input, getPlayerSign());
    }

    private char getPlayerSign() {
        return player == Player.FIRST ? 'X' : 'O';
    }

    private void checkWinner() {
        WinChecker winChecker = new WinChecker(board.getBoardData());
        if (winChecker.isWinner()) {
            endGame(player);
        }

    }

    private void printBoard() {
        for (String[] row : board.getBoardDisplay()) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.print('\n');
        }
    }

    private void endGame(Player winner) {
        System.out.println("Player " + getPlayerSign() + " wins!");
        System.exit(0);
    }

    private void endGame() {
        System.out.println("It's a draw!");
        System.exit(0);
    }


}
