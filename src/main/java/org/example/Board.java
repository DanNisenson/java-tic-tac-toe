package org.example;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Board {

    private final String[][] boardData = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
    };
    private final String[][] boardDisplay = {
            {"|", "---", "|", "---", "|", "---", "|"},
            {"|", "   ", "|", "   ", "|", "   ", "|"},
            {"|", "---", "|", "---", "|", "---", "|"},
            {"|", "   ", "|", "   ", "|", "   ", "|"},
            {"|", "---", "|", "---", "|", "---", "|"},
            {"|", "   ", "|", "   ", "|", "   ", "|"},
            {"|", "---", "|", "---", "|", "---", "|"},
    };

    public String[][] getBoardData() {
        return boardData;
    }

    public String[][] getBoardDisplay() {
        for (int row = 0; row < boardData.length; row++) {
            for (int col = 0; col < boardData[row].length; col++) {
                int mapRow = getMappedIndex(row);
                int mapCol = getMappedIndex(col);
                boardDisplay[mapRow][mapCol] = getFormattedCell(boardData[row][col]);
            }
        }
        return boardDisplay;
    }

    private int getMappedIndex(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 3;
        } else if (i == 2) {
            return 5;
        } else {
            throw new RuntimeException("Board should only be 3x3");
        }
    }

    @NotNull
    @Contract(pure = true)
    private String getFormattedCell(String cell) {
        return " " + cell + " ";
    }

    public void setCell(Integer n, char playerSign) {
        int row = n <= 3 ? 0 : n <= 6 ? 1 : 2;
        int colMod = n <= 3 ? 0 : n <= 6 ? 3 : 6;
        int col = n - colMod - 1;
        this.boardData[row][col] = String.valueOf(playerSign);
    }
}
