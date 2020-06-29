/*
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some server unable to reach some other server.
Return all critical connections in the network in any order.
 O(V + E)
 */
import java.util.*;
public class CriticalConnectionsInNetwork {

}

class Solution {
    List<List<Integer>> network;
    List<List<Integer>> result;
    int time = 1;;
    boolean[] visited;
    int[] low;
    int[] dis;
    int n;
    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.n = n;
        buildNetwork(connections);
        result = new ArrayList<>();
        visited = new boolean[n];
        low = new int[n];
        dis = new int[n];
        getCriticalConnections(0, -1);
        return result;
        
    }
    
    public void buildNetwork(List<List<Integer>> connections)
    {
        network = new ArrayList<>();
        for(int i =0 ; i < n ; i++)
            network.add(new ArrayList<>());
        
        for(List<Integer> edge : connections)
        {
            network.get(edge.get(0)).add(edge.get(1));
            network.get(edge.get(1)).add(edge.get(0));
        }
    }
    
    public void getCriticalConnections(int index , int parent)
    {
        visited[index] = true;
        low[index] = time;
        dis[index] = time;
        time++;
        for(Integer node : network.get(index))
        {
            if(node == parent)
                continue;
            
            if(visited[node] == false)
            {
                  getCriticalConnections(node, index);
                  low[index] = Math.min(low[index],low[node]);
                  if(dis[index] < low[node])
                  {
                    List<Integer> l = new ArrayList<>();
                    l.add(index);
                    l.add(node);
                    result.add(l);
                  }
                
            }
            else
            {
              low[index] = Math.min(low[index],dis[node]);
            } 
            
          
            
        }
        
        
    }
}
