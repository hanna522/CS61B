public class ArrayMax {
    /** Returns the maximum value from arr. */
    public static int max(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty"); // 배열이 비어있을 경우 예외 처리
        }
        
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int maxNumber = max(numbers); // 배열에서 최대값을 찾습니다.
        System.out.println(maxNumber);
    }
}