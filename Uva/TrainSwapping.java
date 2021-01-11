/*============================================================================
  Problem     : 299 - Train Swapping
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : UVa - Accepted - 0.080
  Created on March 14, 2018, 03:30 PM
 ============================================================================*/

import java.util.Scanner;


public class TrainSwapping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int temp;
			int count = 0;
			int l = sc.nextInt();
			int[] order = new int[l];

			for (int j = 0; j < l; j++)
				order[j] = sc.nextInt();

			for (int j = 0; j < l; j++) {
				for (int k = 0; k < l - 1; k++) {
					if (order[k] > order[k + 1]) {
						temp = order[k + 1];
						order[k + 1] = order[k];
						order[k] = temp;
						count++;
					}
				}
			}
			System.out.println("Optimal train swapping takes " + count + " swaps.");
		}
	}
}
