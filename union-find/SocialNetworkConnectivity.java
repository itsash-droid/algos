/**
 * Coursera - Algorithms Part I
 * Week 1 - Interview Questions - Union Find
 *
 * Question 1: Social network connectivity
 *
 * Given a social network containing N members and a log file containing M
 * timestamps at which times pairs of members formed friendships, design an
 * algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an
 * equivalence relation. The running time of your algorithm should be MlogN or
 * better and use extra space proportional to N.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SocialNetworkConnectivity {
	private int N;
	private int[] id;
	private int[] sz;

	private SocialNetworkConnectivity(int N) {
		this.N = N;
		this.id = new int[N];
		this.sz = new int[N];
		initArray();
	}

	private void initArray() {
		for (int i=0; i<N; i++) {
			this.id[i] = i;
			this.sz[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	private String union(int i, int j, String ts) {
		int p = root(i);
		int q = root(j);
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
		SocialNetworkConnectivity obj = new SocialNetworkConnectivity(N);
		try {
			Scanner fileInput = new Scanner(new File(file));
			while (fileInput.hasNextLine()) {
				String fileData = fileInput.nextLine();
				String[] values = fileData.split(",");
				String ts = obj.union(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2]);
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
