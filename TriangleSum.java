// https://www.codechef.com/submit-v2/SUMTRIAN?tab=statement
package com.company.CodeChef;

import java.util.Scanner;

public class TriangleSumMemoization {
    private static int findMaxSum(int [][]triangle){
        int [][]storage = new int[triangle.length][triangle[0].length];
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage.length; j++){
                storage[i][j] = -1;
            }
        }
        return findMaxSum(triangle, 0, 0, storage);
    }

    private static int findMaxSum(int [][]triangle, int row, int col, int [][]storage){
        // Base case :
        if(row >= triangle.length || col >= triangle[row].length){
            return  0;

        }

        if(storage[row][col] != -1){
            return storage[row][col];
        }
        int justDown = triangle[row][col] + findMaxSum(triangle, row+1, col, storage);
        int justRightDown = triangle[row][col] + findMaxSum(triangle, row+1, col+1, storage);
        storage[row][col] =  Math.max(justDown, justRightDown);
        return storage[row][col];
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int n = sc.nextInt();
            int [][]triangle = new int[n][n];
            for(int i=0; i<triangle.length; i++){
                for(int j=0; j<=i; j++){
                    triangle[i][j] = sc.nextInt();
                }
            }
            int ans = findMaxSum(triangle);
            System.out.println(ans);
        }
    }
}
