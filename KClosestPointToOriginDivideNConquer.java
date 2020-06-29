/*
 * O(n) average case complexity
 */
import java.util.*;
class KClosestPointToOriginDivideNConquer {
    public int[][] kClosest(int[][] points, int K) {
        sort(points , 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    void sort(int[][] points , int i , int j , int k)
    {
        if(i >= j)
            return ;
        int pivot = partition(points , i , j);
        int leftLenght = pivot - i + 1;
        if(leftLenght > k )
            sort(points , i , pivot - 1 , k);
        else if(leftLenght < k)
             sort(points , pivot + 1 , j , k - leftLenght);
    }
    
    public int partition(int[][] points , int i , int j)
    {
        int pivot = i;
        int l = i + 1 ;
        int r = j;
        while(true)
        {
            while(l < r && dist(points,l)  <= dist(points , pivot))
                l++;
            while(l <= r && dist(points, r)  > dist(points , pivot) )
                r--;
            if(l >= r)
                break;
            swap(points , l , r);
        }
        swap(points ,pivot , r);
        return r;
    }
    
    public int dist(int[][] points , int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
    
     public void swap(int[][] points , int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}