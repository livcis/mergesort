import java.util.Arrays;

/**
 * 
 */

/**
 * @author Liviu Cismaru
 * Longest Repeating Substring (LRS)
 * Given a string of N characters, find the longest repeated substring. 
 * Includes LCP (Longest COmmon Prefix): Given two strings, find the longest substring that is a prefix of both
 * 
 *
 */


public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		String s = args[0]; //Assuming that args[0] is the long string
		int N = s.length();
		String[] suffixes = new String[N];
		for (int i = 0; i < N; i++)
			suffixes[i] = s.substring(i, N);
		Arrays.sort(suffixes);
		String lrs = "";
		for (int i = 0; i < N - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i+1]);
			if (x.length() > lrs.length()) lrs = x;
		}
		System.out.println(lrs);
	}


	//Given two strings, find the longest substring that is a prefix of both
	public static String lcp(String s, String t)
	{
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++)
		{
			if (s.charAt(i) != t.charAt(i))  return s.substring(0, i);
		}
		return s.substring(0, n);
	}
}

