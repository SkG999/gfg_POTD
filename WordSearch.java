class WordSearch {
    public boolean sol(char[][] mat, String word, int i, int j, int idx, boolean[][] vis) {
        // Base case
        if (idx == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] || mat[i][j] != word.charAt(idx)) {
            return false;
        }
        
        // Recursive case
        vis[i][j] = true;
        
        if (sol(mat, word, i - 1, j, idx + 1, vis) ||
            sol(mat, word, i + 1, j, idx + 1, vis) ||
            sol(mat, word, i, j - 1, idx + 1, vis) ||
            sol(mat, word, i, j + 1, idx + 1, vis)) {
            return true;
        }
        
        vis[i][j] = false;
        return false;
    }
    
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (sol(mat, word, i, j, 0, vis)) return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] mat = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        
        if (solution.isWordExist(mat, word)) {
            System.out.println("Word exists in the matrix.");
        } else {
            System.out.println("Word does not exist in the matrix.");
        }
    }
}
