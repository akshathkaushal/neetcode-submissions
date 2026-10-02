class Solution {
    public List<List<String>> solveNQueens(int n) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++) str.append('.');
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++) {
            board.add(str.toString());
        }

        List<List<String>> res = new ArrayList<>();
        solve(board,res,n-1);
        return res;
    }
    private void solve(List<String> board, List<List<String>> ans, int col) {
        if(col < 0) {
            ans.add(new ArrayList<>(board));
            return;
        }
        int n = board.size();
        for(int row=0;row<n;row++) {
            if(isSafe(board,row,col)) {
                StringBuilder cur = new StringBuilder(board.get(row));
                // place Queen
                cur.setCharAt(col,'Q');
                board.set(row,cur.toString());

                solve(board,ans,col-1);
                
                // remove Queen
                cur.setCharAt(col,'.');
                board.set(row,cur.toString());
            }
        }
    }
    private boolean isSafe(List<String> board, int row, int col) {
        int curRow = row;
        int curCol = col;
        int n = board.size();

        // check upper-right diagonal
        while(col<n && row>=0) {
            if(board.get(row).charAt(col) == 'Q') return false;
            col++;
            row--;
        }

        row = curRow;
        col = curCol;
        // check previous row
        while(col<n) {
            if(board.get(row).charAt(col) == 'Q') return false;
            col++;
        }

        row = curRow;
        col = curCol;
        // check bottom-right diagonal
        while(row<n && col<n) {
            if(board.get(row).charAt(col) == 'Q') return false;
            row++;
            col++;
        }

        return true;
    }
}
