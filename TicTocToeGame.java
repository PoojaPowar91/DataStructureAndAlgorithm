class TicTocToeGame {
    int grid;
    int[][] rows;
    int[][] columns ;
    int ldia[];
    int rdia[];
   
   /** Initialize your data structure here. */
   public TicTocToeGame(int n) {
       grid = n;
       rows = new int[n][2];
       columns = new int[n][2];
       ldia = new int[2];
       rdia = new int[2];
       
   }
   
   /** Player {player} makes a move at ({row}, {col}).
       @param row The row of the board.
       @param col The column of the board.
       @param player The player, can be either 1 or 2.
       @return The current winning condition, can be either:
               0: No one wins.
               1: Player 1 wins.
               2: Player 2 wins. */
   public int move(int row, int col, int player) {    
       rows[row][player - 1] = rows[row][player - 1] + 1;
       if(rows[row][player - 1] == grid)
           return player;
       
       columns[col][player - 1] = columns[col][player - 1] + 1;
       if(columns[col][player - 1] == grid)
           return player;
       
       if(row == col)
       {
            rdia[player - 1]++;
           if(rdia[player - 1] == grid)
               return player;
       }
       
       if(row == grid - col - 1)
       {
             ldia[player - 1]++;
           if(ldia[player - 1] == grid)
               return player;
       }
          
       
       return 0;
           
       
   }
}

/**
* Your TicTacToe object will be instantiated and called as such:
* TicTacToe obj = new TicTacToe(n);
* int param_1 = obj.move(row,col,player);
*/
