public class MergeSort {

    private Comparable[] aux;

    MergeSort() {

    }

    private boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void merge (Comparable[] a, Comparable[] aux, int low, int mid, int high) {

        int k = low;
        int i = low, j = mid+1;
        for (; i<=mid && j<=high;) {
            if (less(a[j], a[i])) {
                aux[k++] = a[j++];
            } else {
                aux[k++] = a[i++];
            }
        }

        while (i<=mid) {
            aux[k++] = a[i++];
        }

        while (j<high) {
            aux[k++] = a[j++];
        }
    }

    private void mergeSort(Comparable[] a, Comparable[] aux, int start, int end) {
        if (start < end) {
            int mid = start + (end - start)/2;
            mergeSort(a, aux, start, mid);
            mergeSort(a, aux, mid + 1, end);
            merge(a, aux, start, mid, end);
        }
    }

    public void sort(Comparable[] a) {
        this.aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    public static void main (String args[]) {
        MergeSort ms = new MergeSort();
        ms.sort(new Integer[] {2,5,6,7,8,1,3,4,7});

        for (Comparable integer : ms.aux) {
            System.out.println(integer);
        }
    }
}