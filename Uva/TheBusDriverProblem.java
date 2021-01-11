/*============================================================================
  Problem     : 11389 - The Bus Driver Problem
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : UVa - Accepted - 0.140
  Created on March 12, 2018, 08:30 PM
 ============================================================================*/

import java.util.Scanner;
import java.util.Arrays;


public class TheBusDriverProblem {
	public static void main(String[] args) {
		int numDrivers, duration, extra;
		int[] morning, evening;

		Scanner sc = new Scanner(System.in);

		while (true) {
			numDrivers = sc.nextInt();
			duration = sc.nextInt();
			extra = sc.nextInt();

			if (numDrivers == 0 && duration == 0 && extra == 0) break;

			morning = new int[numDrivers];
			evening = new int[numDrivers];

			for (int i = 0; i < numDrivers; i++)
				morning[i] = sc.nextInt();
			for (int i = 0; i < numDrivers; i++)
				evening[i] = -sc.nextInt();

			Arrays.sort(morning);
			Arrays.sort(evening);

			int val = 0;
			for (int i = 0; i < numDrivers; i++) {
				int result = morning[i] - (evening[i]);
				if (result > duration)
					val += (result - duration) * extra;
			}
			System.out.println(val);
		}
	}
}
