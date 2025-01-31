//                                                                      NQueens 
//                                                          Read comments carefully 
package backTracking;

import java.util.*;

class Nqueen {
    // Function to solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        // Create an empty chessboard filled with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) // Initialize each cell with '.'
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>(); // Store all possible solutions
        dfs(0, board, res); // Start solving from the first column
        return res; // Return the list of solutions
    }

    // Recursive function to try placing queens column by column
    static void dfs(int col, char[][] board, List<List<String>> res) {
        // Base case: If all queens are placed, save the solution
        if (col == board.length) {
            res.add(construct(board)); // Add the current board configuration to the result
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if placing a queen here is safe
            if (validate(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                dfs(col + 1, board, res); // Recur to place queens in the next column
                board[row][col] = '.'; // Backtrack: Remove the queen and try another position
            }
        }
    }
    // Function to check if placing a queen at (row, col) is safe
    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        // Check the upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') // If another queen is found, return false
                return false;
            row--;
            col--;
        }

        // Reset row and col to their original values
        row = duprow;
        col = dupcol;

        // Check the left side of the current row
        while (col >= 0) {
            if (board[row][col] == 'Q') // If another queen is found, return false
                return false;
            col--;
        }

        // Reset row and col to their original values
        row = duprow;
        col = dupcol;

        // Check the lower-left diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') // If another queen is found, return false
                return false;
            col--;
            row++;
        }

        return true; // If no queen threatens this position, it's safe
    }

    // Function to convert the current board configuration into a list of strings
    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>(); // Create a list to store the configuration
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]); // Convert each row to a string
            res.add(s); // Add the row string to the list
        }
        return res; // Return the configuration
    }

    public static void main(String args[]) {
        int N = 4; // Size of the chessboard (N x N)
        List<List<String>> queen = solveNQueens(N); // Solve the problem
        int i = 1; // Counter for arrangements
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i); // Print the arrangement number
            for (String s : it) {
                System.out.println(s); // Print each row of the arrangement
            }
            System.out.println(); // Add a blank line between arrangements
            i += 1; // Increment the counter
        }
    }
}
