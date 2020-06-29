/*
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
The score of a path is the minimum value in that path.  For example, the value of the path
A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south)
 o(nlogn + V) nlon foro maxheap and v for rdges
 There is one more binary search solution
 */
import java.util.PriorityQueue;

public class PathWithMaximumMinimunValue {
public int maximumMinimumPath(int[][] A) {
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(b[2],a[2]));
        q.add(new int[]{0,0,A[0][0]});
        boolean[][] visited = new boolean[A.length][A[0].length];
        visited[0][0] = true;
        
        while(!q.isEmpty())
        {
            int top[] = q.poll();
            if(top[0] == A.length - 1 && top[1] == A[0].length - 1)
                return top[2];
            
            
           
            for(int[] d : dir)
            {
                int x = top[0] + d[0];
                int y = top[1] + d[1];
                if(x < 0 || y < 0 || x > A.length - 1 || y > A[x].length - 1 || visited[x][y] == true)
                    continue;
                
               
                
                q.add(new int[]{x ,y , Math.min(top[2],A[x][y])});
                 visited[x][y] = true;
          
              
            }
            
        }
        return -1;
        
    }

}
