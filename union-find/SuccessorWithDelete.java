
import java.util.Scanner;


class SuccessorWithDelete {
  
  int N;
  int id[];
  
  SuccessorWithDelete(int N) {
    this.N = N;
    id = new int[N];
    initArray();
  }
  
  
  void initArray() {
    for (int i=0; i<N; i++) {
      this.id[i] = i;
    }
  }
  
  void union(int i, int j) {
    int tmp = id[i];
    for (int k=0; k<N; k++) {
      if (id[k] == tmp) {
        id[k] = id[j];
      }
    }
  }
  
  void delete(int i) {
    union(i, i+1);
  }
  
  int successor(int i) {
    return id[i];
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of elements");
	int N = input.nextInt();
    SuccessorWithDelete obj = new SuccessorWithDelete(N);
    obj.delete(5);
    obj.delete(2);
    System.out.println(obj.successor(2));
    obj.delete(3);
    System.out.println(obj.successor(2));
    obj.delete(4);
    System.out.println(obj.successor(2));
    
  }
}

