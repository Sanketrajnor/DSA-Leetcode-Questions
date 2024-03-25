class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<> ();
        for(int items : nums){
            if(hm.containsKey(items) == true){
                int temp = hm.get(items);
                hm.put(items, temp+1);
            }else{
                hm.put(items,1);
            }
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int items : nums){
            if (hm.get(items) == 2) {
                hs.add(items);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer t : hs) 
            ans.add(t); 
        return ans;
    }
}
