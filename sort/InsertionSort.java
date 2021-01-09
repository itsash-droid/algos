
public class InsertionSort {

    public void sort(Comparable[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j= i; j>0; j--) {
                if (less(arr[j], arr[j-1])) {
                    exch(arr, j, j-1);
                }
            }
        }
    }

    private boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch (Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main (String args[]) {
        InsertionSort ss = new InsertionSort();
        Integer arr[] =  {2,9,4,1,3,12,9,0,11,5};
        ss.sort(arr);
        for (Integer item : arr) {
            System.out.println(item);
        }
        
    }
}