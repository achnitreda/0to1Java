public class ComputeArray {
    public static void main(String[] args) {
        int[] array = ComputeArray.computeArray(new int[]{9, 13, 8, 23, 1, 0, 89});
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    public static int[] computeArray(int[] array) {
        if (array == null) return null;
        int[] res = new int[array.length];
        for (int i=0;i<array.length;i++) {
            if (array[i]%3 == 0) {
                res[i] = array[i]*5;
            }else if ((array[i] > 0) && (array[i]-1)%3 == 0) {
                res[i] = array[i]+7;
            }else {
                res[i] = array[i];
            }
        }
        return res;
    }
}