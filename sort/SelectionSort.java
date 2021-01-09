
public class SelectionSort {

    private boolean less (Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) return true;
        return false;
    }

    private void exch (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(Comparable[] arr) {
        for (int i=0; i<arr.length; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }

            exch (arr, i, min);
        }
    }

    public static void main (String args[]) {
        SelectionSort ss = new SelectionSort();
        Integer arr[] =  {2,9,4,1,3,12,9,0,11,5};
        ss.sort(arr);
        for (Integer item : arr) {
            System.out.println(item);
        }
        
    }

}
