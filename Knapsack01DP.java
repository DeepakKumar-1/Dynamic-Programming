package com.company.DPRevision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Knapsack01DP {

    // DP Approach
    public static int knapsackDP(int []weight, int []value, int maxWeight){
        int m = weight.length;
        int n = maxWeight; // columns
        int [][]storage = new int[m+1][n+1];
        // if weight is 0 then Max Profit you can get is 0
        for(int i=0; i<m; i++){
            storage[i][0] = 0;
        }
        // if profit (i.e value) is 0 then for all weights you can max Profit of 0
        for(int j=0; j<n; j++){
            storage[0][j] = 0;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
               if(weight[i-1] > j){
                   storage[i][j] = storage[i-1][j];
               } else{
                   storage[i][j] = Math.max(storage[i-1][j], value[i-1] + storage[i-1][j- weight[i-1]]);
               }
            }
        }
        for(int []row : storage){
            System.out.println(Arrays.toString(row));
        }
        return storage[m][n];
    }

    public static void main(String[] args) {
//        int []weight = {6, 1, 4, 2, 5};
//        int []value = {10, 5, 4, 8, 6};
//        int maxWeight = 5;
//        int []weight = {1, 3, 4, 6};
//        int []value = {20, 30, 10, 50};
//        int maxWeight = 10;
        int []weight = {2, 3, 5 ,7, 1, 4, 1};
        int []value = {10, 5, 15, 7, 6, 18, 3};
        int maxWeight = 15;
        System.out.println(knapsackDP(weight, value, maxWeight));
    }
}
