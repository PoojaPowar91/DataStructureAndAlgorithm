/*
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
 */

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfsUtil(image , sr , sc , image[sr][sc] , newColor);
        return image;
        
        
    }
    
    void dfsUtil(int[][] image, int i, int j, int start , int newColor)
    {
        if(i < 0 || j < 0 || i > image.length - 1 || j > image[i].length - 1 || image[i][j] == newColor || image[i][j] != start)
            return;
        
        image[i][j] = newColor;
        dfsUtil(image , i+1 , j , start , newColor);
        dfsUtil(image , i-1 , j , start , newColor);
        dfsUtil(image , i , j + 1 , start , newColor);
        dfsUtil(image , i , j - 1 , start , newColor);
        
    }
}
