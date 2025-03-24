package NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(0, board, result);
        return result;
    }

    public void dfs(int col, char[][] board, List<List<String>> result) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(row, col, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    public boolean validate(int row, int col, char[][] board) {
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
