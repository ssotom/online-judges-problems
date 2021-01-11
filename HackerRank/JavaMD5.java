/*============================================================================
  Problem     : Java MD5
  Author      : Santiago Soto
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/java-md5/problem
  Created on January 2021
 ============================================================================*/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] digest = md.digest();

		/* Print the encoded value in hexadecimal */
		for (byte b : digest) {
			System.out.format("%02x", b);
		}
	}
}
