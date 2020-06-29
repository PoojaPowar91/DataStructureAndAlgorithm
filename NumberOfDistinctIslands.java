/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 */

import java.util.*;
class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        Set<String> islands = new HashSet<>();
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
              
                if(grid[i][j] == 1)
                {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid , i , j , sb , 'o');
                    islands.add(sb.toString());
                }
                    
            }
        }
        return islands.size();
        
    }
    
    void dfs(int[][] grid , int i , int j , StringBuilder sb , char d)
    {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        sb.append(d);
        dfs(grid , i - 1 , j ,sb , 'u');
        dfs(grid , i + 1 , j ,sb , 'd');
        dfs(grid , i , j - 1 ,sb , 'l');
        dfs(grid , i , j + 1 ,sb , 'r');
         sb.append('b');
    }
}
