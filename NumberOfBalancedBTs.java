package com.company.DPRevision;

public class NumberOfBalancedBTs {
    // Recursive Approach
    public static int countBalancedBTs(int h){
        // Base Case
        if(h == 0 || h == 1){
            return 1;
        }
        int x = countBalancedBTs(h-1);
        int y = countBalancedBTs(h-2);
        return (int)Math.pow(x, 2) + 2*x*y;
    }

    // Memoization Approach
    public static int countBalancedBTsM(int h){
        int []storage = new int[h+1];
        return countBalancedBTsM(h, storage);
    }
    private static int countBalancedBTsM(int h, int []storage){
        // Base Case
        if(h == 0 || h == 1){
            storage[h] = 1;
            return storage[h];
        }
        // if result is already Calculated
        if(storage[h] != 0){
            return storage[h];
        }
        // otherwise Calculate the result
        int x = countBalancedBTsM(h-1, storage);
        int y = countBalancedBTsM(h-2, storage);
        storage[h] = (int)Math.pow(x, 2) + 2*x*y;
        return storage[h];
    }

    // DP Approach
    public static int countBalancedBTsDP(int h){
        int []storage = new int[h+1];
        storage[0] = 1;
        storage[1] = 1;
        for(int i=2; i<storage.length; i++){
            int x = storage[i-1];
            int y = storage[i-2];
            storage[i] = (int)Math.pow(x, 2) + 2*x*y;
        }
        return storage[h];
    }

    public static void main(String []args){
        int h = 5;
        System.out.println(countBalancedBTsDP(h));
        System.out.println(countBalancedBTsM(h));
        System.out.println(countBalancedBTs(h));
    }
}
