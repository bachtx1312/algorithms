public class Median2SortedArray {
    public static void main(String[] args) {
        double median = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < m && nums1[i] < nums2[j]) {
                iMin++;
            } else if (i > 0 && nums1[i] > nums2[j]) {
                iMax--;
            } else {
                int medianLeft = 0;
                if (i == 0) {
                    medianLeft = nums2[j - 1];
                } else if (j == 0) {
                    medianLeft = nums1[i - 1];
                } else {
                    medianLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 != 0) {
                    return medianLeft;
                }

                int medianRight = 0;
                if (i == n) {
                    medianRight = nums2[j];
                } else if (j == n) {
                    medianRight = nums1[i];
                } else {
                    medianRight = Math.min(nums1[i], nums2[j]);
                }

                return (medianLeft + medianRight) / 2.0;
            }
        }

        return 0;
    }
}
