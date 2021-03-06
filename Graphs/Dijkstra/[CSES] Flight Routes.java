// VVGood Problem
// Problem : https://cses.fi/problemset/task/1196/
// O(MKlog(MK) Time + O(MK) Space
// [AC for all, TLE in some due to JVM, same CPP code gives full AC]

import java.io.*;
import java.util.*;
 
public class Solution {
	
	static final int INF = Integer.MAX_VALUE;
	static final int NINF = Integer.MIN_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final long LNINF = Long.MIN_VALUE;
	static Reader reader;
	static Writer writer;
	static PrintWriter out;
	static FastScanner fs;


	static class Node {
		int node;
		long cost;
		Node(int n, long c) {
			node = n;
			cost = c;
		}
	}

	static void solve() {
		int n = fs.nextInt();
		int m = fs.nextInt();
		int k = fs.nextInt();

		ArrayList<ArrayList<Node>> g = new ArrayList<>();
		for (int i = 0; i < n; i++)
			g.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int x = fs.nextInt();
			int y = fs.nextInt();
			int w = fs.nextInt();
			x--;
			y--;
			g.get(x).add(new Node(y, w)); 
		}
		
		

		PriorityQueue<Node> pq = new PriorityQueue<>((Node first, Node second) -> {
			if (first.cost == second.cost)
				return 0;
			else return first.cost > second.cost?1:-1;
		});

		ArrayList<PriorityQueue<Long>> costs = new ArrayList<>(); 
		// cost[i] -> contains k cheapest costs of travelling from city 0 to city i in the form of max heap

		for (int i = 0; i < n; i++) {
			costs.add(new PriorityQueue<>(Collections.reverseOrder())); // k max-heaps
		}

		pq.add(new Node(0, 0));
		
		while (!pq.isEmpty()) {
			Node parent = pq.poll();

			for (Node adj : g.get(parent.node)) {
				if (costs.get(adj.node).size() < k) {
					costs.get(adj.node).add(adj.cost + parent.cost);
					pq.add(new Node(adj.node, adj.cost + parent.cost));
				} else if (costs.get(adj.node).size() == k && costs.get(adj.node).peek() > adj.cost + parent.cost) {	
					// poll the curr max cost
					costs.get(adj.node).poll();	
					//store the new smaller cost
					costs.get(adj.node).add(adj.cost + parent.cost);
					pq.add(new Node(adj.node, adj.cost + parent.cost));				
				}
				
			}
				
		}
		
		printAns(costs.get(n-1));
		out.print("\n");

	}

	static void printAns(PriorityQueue<Long> costs) {
		if (costs.isEmpty()) {
			return;
		}
		long cost = costs.poll();
		printAns(costs);
		out.print(cost + " ");
	}



		

	public static void main(String[] args) {
		setReaderWriter();
		fs = new FastScanner(reader);
		// testForTestcases();
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

	static void testForTestcases() {
		int T = fs.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static boolean isInteger(double val) {
		return !(val - (long)val > 0);
	}

	static void swap(int[] a , int i , int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static long GCD(long a,long b) 
	{
		if(b==0)
		{
			return a;
		}
		else return GCD(b,a%b );
	}

	static int opposite(int n, int x) {
		return (n-1)^x;
	}
	
	static Pair print(int a, int b) {
		out.println(a+" "+b);
		return new Pair(a, b);
	}
	
	static class Pair {
		long a;
		int b;
		public Pair(long a, int b) {
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

		int[] readArrayInt(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}

		long[] readArrayLong(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
