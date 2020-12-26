import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LargestElementConnectedComp {
	private int N;
	private int[] id;
	private int[] sz;
	private int[] max;

	private LargestElementConnectedComp(int N) {
		this.N = N;
		this.id = new int[N];
		this.sz = new int[N];
		this.max = new int[N];
		initArray();
	}

	private void initArray() {
		for (int i=0; i<N; i++) {
			this.id[i] = i;
			this.sz[i] = 1;
			this.max[i] = i;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	private int find(int i) {
		return max[root(i)];
	}

	private String union(int i, int j, String ts) {
		int p = root(i);
		int q = root(j);

		if (max[p] > max[q]) {
			max[q] = max[p];
		} else {
			max[p] = max[q];
		}

		if (p == q) return null;
		if (sz[p] >= sz[q]) {
			id[q] = p;
			sz[p] += sz[q];
			if (sz[p] == N) return ts;
		} else {
			id[p] = q;
			sz[q] += sz[p];
			if (sz[q] == N) return ts;
		}

		return null;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter file name with path");
		String file = input.nextLine();
		System.out.println("Enter number of members");
		int N = input.nextInt();
		LargestElementConnectedComp obj = new LargestElementConnectedComp(N);
		try {
			Scanner fileInput = new Scanner(new File(file));
			while (fileInput.hasNextLine()) {
				String fileData = fileInput.nextLine();
				String[] values = fileData.split(",");
				int p = Integer.parseInt(values[0]);
				int q = Integer.parseInt(values[1]);
				String ts = obj.union(p, q, values[2]);
				for (int i=0; i<N; i++) {
					System.out.print(obj.find(i));
				}
				System.out.println();
				if (ts != null) {
					System.out.println(ts);
					break;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
