/*
 * O(N + E)
 */
public class PathWithMaximumMinimunValueBinarySearch {
	int m;
	int n;

	// these two arrays help us iterate over four directions
	int[] dr = new int[]{1, -1, 0, 0};
	int[] dc = new int[]{0, 0, 1, -1};
	 private int binarySearch(int[][] A) {
	        int min = 0;
	        int max = Math.min(A[0][0], A[m - 1][n - 1]);
	        int ans = 0;
	        while (max - min > 1) {
	            int mid = (min + max) / 2;
	            boolean[][] visited = new boolean[m][n];
	            visited[0][0] = true;
	            if (hasPath(A, 0, 0, visited, mid)) {
	                min = mid;
	                ans = mid;
	            } else {
	                max = mid;
	            }
	        }
	        boolean[][] visited = new boolean[m][n];
	        visited[0][0] = true;
	        if (hasPath(A, 0, 0, visited, max)) ans = max;
	        return ans;
	    }

	    private boolean hasPath(int[][] A, int r, int c, boolean[][] visited, int limit) {
	        visited[r][c] = true;
	        if (r == m - 1 && c == n - 1) return true;
	        for (int i = 0; i < 4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];
	            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && A[nr][nc] >= limit) {
	                if (hasPath(A, nr, nc, visited, limit)) return true;
	            }
	        }
	        return false;
	    }

}
