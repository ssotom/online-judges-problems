/*============================================================================
  Problem     : 291 - The House Of Santa Claus
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : UVa - Accepted - 0.050
  Created on March 14, 2018, 02:30 PM
 ============================================================================*/

import java.util.Arrays;

public class TheHouseOfSantaClaus{
    
    static boolean[][] m = new boolean[5][5];
    static int result[] = new int[8];
    public static void main(String[] args){
        m[0][1]=m[0][2]=m[0][4]=true;
        m[1][0]=m[1][2]=m[1][4]=true;
        m[2][0]=m[2][1]=m[2][3]=m[2][4]=true;
        m[3][2]=m[3][4]=true;
        m[4][0]=m[4][1]=m[4][2]=m[4][3]=true;
        
        routes(0,0);
    }
    
    public static void routes(int cont, int now){
        if(cont == 8){
            for(int i :result)
                System.out.print(i);
            System.out.println(2);   
            return;
        }
        result[cont] = now+1;
        for(int i=0 ;i<5; i++){
            if(m[now][i]){
              m[now][i] = m[i][now] = false;
              routes(cont+1,i);
              m[now][i] = m[i][now] = true;
            }
        }
    } 
}