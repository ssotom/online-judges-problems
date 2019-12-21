/*============================================================================
  Problem     : Extra Long Factorials
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/extra-long-factorials
  Created on 2017
 ============================================================================*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void extraLongFactorials(int n) {
        BigInteger factorial = new BigInteger("1");
        for(int i = n;i>=1;i--){
           factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
