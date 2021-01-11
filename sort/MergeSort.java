public class MergeSort {

    private Comparable[] aux;

    MergeSort() {

    }

    private boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void merge (Comparable[] a, Comparable[] aux, int low, int mid, int high) {

        for (int k = low; k<=high; k++){
            aux[k] = a[k];
        }


        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i>mid) a[k] = aux[j++];
            else if (j>high) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = a[i++];
            else a[k] = a[j++];
        }
    }

    private void mergeSort(Comparable[] a, Comparable[] aux, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start)/2;
        mergeSort(a, aux, start, mid);
        mergeSort(a, aux, mid + 1, end);
        merge(a, aux, start, mid, end);
    }

    public void sort(Comparable[] a) {
        this.aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private void print(Comparable[] arr) {
        for (Comparable integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main (String args[]) {
        MergeSort ms = new MergeSort();
        Integer[] a = new Integer[] {2,5,6,7,8,1,3,4,7};
        ms.sort(a);
        ms.print(a);
        a = new Integer[] {1,2,3,4,5,6,7,8,9};
        ms.sort(a);
        ms.print(a);
        a = new Integer[] {9,8,7,6,5,4,3,2,1};
        ms.sort(a);
        ms.print(a);
    }
}