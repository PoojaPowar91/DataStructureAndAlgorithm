/*
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
 * Complexity : O(2^N) -> n is number of cells in prison
 */

import java.util.*;
class PrisonCellAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String , Integer> map = new HashMap<>();
        int[] newCells = Arrays.copyOf(cells , cells.length);
        int i = 0;
        while(i < N)
        {
            String current = Arrays.toString(newCells);
            map.put( current , i );
            newCells = getPrisonCells(newCells);
            if(map.containsKey(Arrays.toString(newCells)))
            {
                int cycle = i + 1 - map.get(Arrays.toString(newCells));
                int remaining = N - (i + 1);
                for(int j = 0 ; j < remaining % cycle ; j++ )
                {
                      newCells = getPrisonCells(newCells);
                }
                return newCells;
            }
            i++;
            
        }
        return newCells;
        
    }
    
    int[] getPrisonCells(int[] cells)
    {
        int[] newCells = new int[cells.length];
        for(int i = 1 ; i < cells.length - 1; i++)
        {
            if(cells[i - 1] == cells[i + 1])
                newCells[i] = 1;
            else
                newCells[i] = 0;
        }
        return newCells;
    }
}
