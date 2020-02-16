/*============================================================================
  Problem     : Java BigDecimal
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/java-bigdecimal/
  Created on February 2019
 ============================================================================*/
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

public class Solution{
    public static void main(String[] args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String[] s=new String[n+2];
        for(int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, 0, n, (s1, s2) -> {
            BigDecimal a = new BigDecimal(s1);
            BigDecimal b = new BigDecimal(s2);
            return b.compareTo(a);
        });
        
        //Output
        for(int i = 0 ; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}