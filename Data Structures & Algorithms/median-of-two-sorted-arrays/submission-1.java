class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] sortedArr = new int[size];
        

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length || j < nums2.length)
        {
            if(i < nums1.length && j < nums2.length)
            {
                if(i < nums1.length && nums1[i] <= nums2[j]) {
                    sortedArr[k] = nums1[i];
                    i++;
                } else {
                    sortedArr[k] = nums2[j];
                    j++;
                }
            } else if(i < nums1.length) {
                sortedArr[k] = nums1[i];
                i++;
            } else {
                sortedArr[k] = nums2[j];
                j++;
            }
            k++;
        }

        if(size % 2 == 0)
            return (double) (sortedArr[size/2] + sortedArr[size/2-1]) / 2;
        return sortedArr[size/2];
    }
}
