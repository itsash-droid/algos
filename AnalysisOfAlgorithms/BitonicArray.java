//1, 3, 4, 6, 9, 14, 11, 7, 2, -4, -9
public class BitonicArray {

    private int findBisection(int [] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;

        //first find the bisecting point
        int middle = -1;
        while (start < end) {
            middle = start + (end - start)/2;
            //System.out.println(middle);
            if ((middle+1<=inputArray.length - 1 && inputArray[middle] > inputArray[middle+1]) &&
                (middle-1>=0 && inputArray[middle] > inputArray[middle-1])) {                    
                    break;
            } else if (inputArray[middle] < inputArray[middle+1]) {
                    start = middle + 1;
            } else if (inputArray[middle] > inputArray[middle+1]) {
                    end = middle - 1;
            }
        }
        if (start == end) return start;
        return middle;
    } 

    private int binarySearch(int [] inputArray, int startIdx, int endIdx, int k, boolean reverse) {
        int start = startIdx;
        int end = endIdx;

        int middle = -1;
        while (start < end) {
            middle = start + (end - start)/2;
            System.out.println(middle);
            if (!reverse) {
                if (inputArray[middle] < k) {
                    start = middle + 1;
                } else if (inputArray[middle] > k) {
                    end = middle - 1;
                } else {
                    return middle;
                }
            } else {
                if (inputArray[middle] < k) {
                    end = middle - 1;
                } else if (inputArray[middle] > k) {
                    start = middle + 1;
                } else {
                    return middle;
                }
            }

            if (start == end && inputArray[start] == k) return start; 
        }
        return -1;
    }

    public int findK(int[] inputArray, int k) {
        int bisection = findBisection(inputArray);
        int idx = binarySearch(inputArray, 0, bisection, k, false);
        return idx == -1 ? binarySearch(inputArray, bisection + 1, inputArray.length - 1, k, true) : idx;
    }

    public static void main (String args[]) {
        BitonicArray arr = new BitonicArray();
        System.out.println(arr.findK(new int[] {1, 3, 4, 6, 9, 14, 11, 7, 2, -4, -9}, -100));
    }
}
