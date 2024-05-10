package org.example;

import org.jetbrains.annotations.NotNull;

public class WinChecker {
    String[][] boardData;

    public WinChecker(String[][] boardData) {
        this.boardData = boardData;
    }

    boolean isWinner() {
        String[][] winningConditions = getBoardCellCombinations();

        for (String[] winCase : winningConditions) {
            String firstCellOfCase = winCase[0];
            int matchesAmt = 0;
            for (String cell : winCase) {
                if (firstCellOfCase.length() != 0 && firstCellOfCase.equals(cell)) {
                    matchesAmt++;
                }
            }
            if (matchesAmt == 3) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    private String[][] getBoardCellCombinations() {
        return new String[][]{
                // Winning rows
                {boardData[0][0], boardData[0][1], boardData[0][2]},
                {boardData[1][0], boardData[1][1], boardData[1][2]},
                {boardData[2][0], boardData[2][1], boardData[2][2]},
                // Winning cols
                {boardData[0][0], boardData[1][0], boardData[2][0]},
                {boardData[0][1], boardData[1][1], boardData[2][1]},
                {boardData[0][2], boardData[1][2], boardData[2][2]},
                // Winning diagonals
                {boardData[0][0], boardData[1][1], boardData[2][2]},
                {boardData[2][0], boardData[1][1], boardData[0][2]}
        };
    }
}
