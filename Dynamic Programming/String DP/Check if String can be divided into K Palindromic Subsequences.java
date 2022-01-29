import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
 

public class Solution {
	
	static final int INF = Integer.MAX_VALUE;
	static final int NINF = Integer.MIN_VALUE;
	static Reader reader;
	static Writer writer;
	static PrintWriter out;
	static FastScanner fs;
	
 
	static boolean canBeDividedIntoPalindrome(String str, int k, int left, int right, String alt, int sizeOfPal) {

		if (k == 0) return str.length() == 0;

		if (k > str.length() + alt.length()) {
		return false;
		}

		if (left == right) {
			return canBeDividedIntoPalindrome(alt, k - 1, 0, alt.length() - 1, "", 0);
		}
		 
		if (left > right) {
		return sizeOfPal > 0 && canBeDividedIntoPalindrome(alt, k - 1, 0, alt.length() - 1, "", 0);
		}
		 
		boolean ans = false;

		if (str.charAt(left) == str.charAt(right)) {
		ans |= canBeDividedIntoPalindrome(str, k, left + 1, right - 1, alt, sizeOfPal + 2);

		String alt3 = str.charAt(left) + alt + str.charAt(right);

		ans |= canBeDividedIntoPalindrome(str, k, left + 1, right - 1, alt3, sizeOfPal);
		}
		 
		String alt1 = str.charAt(left) + alt;
		ans |= canBeDividedIntoPalindrome(str, k, left + 1, right, alt1, sizeOfPal);

		String alt2 = alt + str.charAt(right);
		ans |= canBeDividedIntoPalindrome(str, k, left, right - 1, alt2, sizeOfPal); 

		return ans;

} 

	static void solve() {

		int T = fs.nextInt();
		while(T-- > 0) {
			String str = fs.next();
			int k = fs.nextInt();
			int left = 0;
			int right = str.length() - 1;
			out.println(str + " " + k + " " + canBeDividedIntoPalindrome(str, k, left, right, "", 0));
		}
	}


	public static void main(String[] args) {
		setReaderWriter();
		fs = new FastScanner(reader);
		solve();
		out.close();
	}

	static void setReaderWriter() {
		try {
			boolean oj = System.getProperty("ONLINE_JUDGE") != null;
			reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
			writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
			out=new PrintWriter(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	static int oppisite(int n, int x) {
		return (n-1)^x;
	}
	
	static Pair print(int a, int b) {
		out.println(a+" "+b);
		return new Pair(a, b);
	}
	
	static class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	
	static final Random random=new Random();
	static final int mod=1_000_000_007;
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static long add(long a, long b) {
		return (a+b)%mod;
	}
	static long sub(long a, long b) {
		return ((a-b)%mod+mod)%mod;
	}
	static long mul(long a, long b) {
		return (a*b)%mod;
	}
	static long exp(long base, long exp) {
		if (exp==0) return 1;
		long half=exp(base, exp/2);
		if (exp%2==0) return mul(half, half);
		return mul(half, mul(half, base));
	}
	static long[] factorials=new long[2_000_001];
	static long[] invFactorials=new long[2_000_001];
	static void precompFacts() {
		factorials[0]=invFactorials[0]=1;
		for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
		invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
		for (int i=invFactorials.length-2; i>=0; i--)
			invFactorials[i]=mul(invFactorials[i+1], i+1);
	}
	
	static long nCk(int n, int k) {
		return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(Reader reader) {
			br =new BufferedReader(reader);
			st =new StringTokenizer("");
		}
		

		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
		
		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}	
}
