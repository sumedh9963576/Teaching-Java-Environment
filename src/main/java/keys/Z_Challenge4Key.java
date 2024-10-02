package keys;

public class Z_Challenge4Key {

    public Z_Challenge4Key(){}

    public void quicksort(int[] arr, int low, int high){
        // DO BUT BETTER
        if(low < high){
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public void exercise3(){
        // Write a function that implements depth-first search (DFS) in a graph
        int[][] graph = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        boolean[] visited = new boolean[graph.length];
        dfs(graph, 0, visited);
        // should print nodes visited in DFS order
    }

    public void dfs(int[][] graph, int node, boolean[] visited){
        visited[node] = true;
        System.out.println("Visited node " + node);
        for(int i = 0; i < graph.length; i++){
            if(graph[node][i] == 1 && !visited[i]){
                dfs(graph, i, visited);
            }
        }
    }

    public void exercise4(){
        // Write a function that solves a Sudoku puzzle using backtracking
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(solveSudoku(board)){
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    public boolean solveSudoku(int[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == 0){
                    for(int num = 1; num <= 9; num++){
                        if(isValid(board, row, col, num)){
                            board[row][col] = num;
                            if(solveSudoku(board)){
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int[][] board, int row, int col, int num){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num){
                return false;
            }
        }
        return true;
    }

    public void printBoard(int[][] board){
        for(int r = 0; r < 9; r++){
            for(int d = 0; d < 9; d++){
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if(r % 3 == 2){
                System.out.print("");
            }
        }
    }

    public void exercise5(){
        // Write a function that implements the Knuth-Morris-Pratt (KMP) string matching algorithm
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmpSearch(text, pattern);
        // should print index where the pattern starts
    }

    public void kmpSearch(String text, String pattern){
        int M = pattern.length();
        int N = text.length();

        int[] lps = new int[M];
        int j = 0;

        computeLPSArray(pattern, M, lps);

        int i = 0;
        while(i < N){
            if(pattern.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if(j == M){
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if(i < N && pattern.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public void computeLPSArray(String pattern, int M, int[] lps){
        int length = 0;
        lps[0] = 0;
        int i = 1;
        while(i < M){
            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            } else {
                if(length != 0){
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
