package com.company.DPRevision;

import java.util.Arrays;

public class LCS1 {
    public static int lcs(String s, String t){
        // Base Case
        if(s.length() == 0 || t.length() == 0){
            return 0;
        }
        // if First Characters Matched
        if(s.charAt(0) == t.charAt(0)){
            return 1+lcs(s.substring(1), t.substring(1));
        }
        // if not matched
            int opt1 = lcs(s.substring(1), t.substring(1));
            int opt2 = lcs(s, t.substring(1));
            int opt3 = lcs(s.substring(1), t);
            return Math.max(opt1, Math.max(opt2, opt3));

    }

    // Memoization Approach
    public static int lcsM(String s, String t){
        int [][]storage = new int[s.length() +  1][t.length() +  1];
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<=t.length(); j++){
                storage[i][j] = -1;
            }
        }

        return lcsM(s, t, storage);
    }
    private static int lcsM(String s, String t, int [][]storage){
        int m = s.length();
        int n = t.length();
        // Base Case
        if(m == 0 || n == 0){
            storage[m][n] = 0;
            return storage[m][n];
        }
        // if result is Already Calculated
        if(storage[m][n] != -1){
            return storage[m][n];
        }
        // otherwise calculate the result
        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = 1+lcs(s.substring(1), t.substring(1));
            return  storage[m][n];
        }else {
            int opt1 = lcs(s, t.substring(1));
            int opt2 = lcs(s.substring(1), t);
            storage[m][n] = Math.max(opt1, opt2);
            return storage[m][n];
        }
    }

    // DP Approach
    public static int lcsDP(String s, String t){
        int m = s.length();
        int n = t.length();
        int [][]storage = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                storage[i][j] = -1;
            }
        }
        for(int i=0; i<m+1; i++){
            storage[i][0] = 0;
        }
        for(int j=0; j<n+1; j++){
            storage[0][j] = 0;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(m-i) == t.charAt(n-j)){
                    storage[i][j] = 1 + storage[i-1][j-1];
                }else{
                    storage[i][j] = Math.max(storage[i][j-1], storage[i-1][j]);
                }
            }
        }
        for(int []row : storage){
            System.out.println(Arrays.toString(row));
        }
        return storage[m][n];
    }

    public static void main(String []args){
//        String s = "adgei";
//        String t = "abegi";
        String s = "dei";
        String t = "gei";
        System.out.println(lcsM(s, t));
        System.out.println(lcsDP(s, t));
        System.out.println(lcs(s, t));
    }
}
