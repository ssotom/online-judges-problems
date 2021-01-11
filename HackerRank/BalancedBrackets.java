/*============================================================================
  Problem     : Balanced Brackets
  Author      : Santiago Soto 
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/balanced-brackets
  Created on 2017
  Edited on January 2021
 ============================================================================*/

import java.io.*;
import java.util.*;


public class Solution
{

	static String isBalanced(String str) {
		Deque<Character> deque = new LinkedList<>();

		if (str.length() % 2 != 0 || str.startsWith(")") || str.startsWith("}") || str.startsWith("]")) {
			return "NO";
		}

		for (char ch : str.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(') {
				deque.push(ch);
			} else if (!deque.isEmpty()) {
				char ch2 = deque.peek();
				if ((ch2 == '(' && ch == ')') || (ch2 == '{' && ch == '}') || (ch2 == '[' && ch == ']')) {
					deque.pop();
				} else {
					break;
				}
			}
		}

		return deque.isEmpty() ? "YES" : "NO";
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
