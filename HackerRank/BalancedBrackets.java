/*============================================================================
  Problem     : Balanced Brackets
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/balanced-brackets
  Created on 2017
 ============================================================================*/

 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {
        Stack<Character> pila = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('|| c=='{' || c=='['){
                pila.push(c);
            }else if(!pila.empty()){
                char d=pila.pop();
                if((d=='('&& c==')')||(d=='{'&& c=='}')||(d=='['&& c==']')){
                    continue;
                }else{
                    pila.push(d);
                }       
            }else{pila.push(c);break;}
        }if(pila.empty()){
            return "YES";
        }else{
           return "NO";
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
