package com.company.DPRevision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Knapsack01 {

    // Memoization Approach
    public static int knapsackM(int []weight, int []value, int

            maxWeight){
        int [][]storage = new int[maxWeight + 1][value.length+1];
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[0].length; j++){
                storage[i][j] = -1;
            }
        }
        return knapsackM(weight, value, maxWeight, 0,  storage);
    }
    private static int knapsackM(int []weight, int []value, int maxWeight,int i, int [][]storage){
        int m = maxWeight;
        int n = i;
        // Base case
        if(maxWeight == 0 || i >= weight.length){
            storage[m][n] = 0;
            return storage[m][n];
        }
        // if Result is already calculated
        if(storage[m][n] != -1){
            return storage[m][n];
        }
        // calculate the result
        if(weight[i] > maxWeight){
            storage[m][n] = knapsackM(weight, value, maxWeight, i+1, storage);
            return storage[m][n];
        } else{
            // include this item
            int opt1 = value[i] + knapsackM(weight, value, maxWeight-weight[i], i+1, storage);
            // Don't include
            int opt2 = knapsackM(weight, value, maxWeight, i+1, storage);
            storage[m][n] = Math.max(opt1, opt2);
            return storage[m][n];
        }
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
        System.out.println(knapsackM(weight, value, maxWeight));
    }
}
