class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hm = new HashSet<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hm.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hm.contains(nums2[i])) {
                hs.add(nums2[i]);
            }
        }
        int arr[] = new int[hs.size()];
        int idx = 0;
        for (int num : hs) {
            arr[idx++] = num;
        }
        return arr;
    }
}