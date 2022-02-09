// GOOGLE Question : https://leetcode.ca/2019-02-10-1168-Optimize-Water-Distribution-in-a-Village/
// The CF problem solved here is similar to above Question
// CF Problem Link : https://codeforces.com/contest/1245/problem/D
// O(ElogE) Time + O(V + E) Space
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

	
	static class Edge {
		int begin, end;
		long cost;
	}

	static class DSU {
		int[] parent;
		int[] size;
		
		DSU(int n) {
			parent = new int[n];
			size = new int[n];
		}

		void makeSet(int i) {
			parent[i] = i;
		}

		int findPar(int i) {
			if (i == parent[i]) {
				return i;
			}

			return parent[i] = findPar(parent[i]);
		}

		void union(int a, int b) {
			int parent_a = findPar(a);
			int parent_b = findPar(b);

			if (parent_a != parent_b ) {
				if (size[parent_a] < size[parent_b]) {
					int temp = parent_a;
					parent_a = parent_b; parent_b = temp;
				}
				parent[parent_b] = parent_a;
				size[parent_a] += size[parent_b]; 
			}
		}

	}


	static void solve() {
		int n = fs.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = fs.nextInt();
			y[i] = fs.nextInt();
		}

		int[] c = fs.readArrayInt(n);

		int[] k = fs.readArrayInt(n);

		ArrayList<Edge> edges = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				Edge edge = new Edge();
				edge.begin = i;
				edge.end = j;
				edge.cost = (long)(k[i] + k[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
				edges.add(edge);
			}
		}

		for (int i = 0; i < n; i++) {
			Edge edge = new Edge();
			edge.begin = i;
			edge.end = n;
			edge.cost = c[i];
			edges.add(edge);
		}


		Collections.sort(edges, (Edge a, Edge b) -> {
			if (a.cost == b.cost) return 0;
			else if (a.cost > b.cost) return 1;
			else return -1;
		});

		long cost = 0;
		int countPowerStations = 0;
		int countConnections = 0;
		ArrayList<Integer> powerStations = new ArrayList<>();
		ArrayList<Pair> connections = new ArrayList<>();


		DSU dsu = new DSU(n+1);

		for (int i = 0; i <= n; i++) {
			dsu.makeSet(i);
		}

		for (Edge e : edges) {
			if (dsu.findPar(e.begin) != dsu.findPar(e.end)) {
				dsu.union(e.begin, e.end);
				cost += e.cost;
				if (e.end == n) {
					countPowerStations++;
					powerStations.add(e.begin + 1);
				} else {
					countConnections++;
					connections.add(new Pair(e.begin + 1, e.end + 1));
				}
			}
		}

		out.println(cost);
		out.println(countPowerStations);
		for (int p : powerStations) {
			out.print(p + " ");
		}
		out.println();
		out.println(countConnections);
		for(Pair p : connections) {
			out.println(p.a + " " + p.b);
		}
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
