class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : order.toCharArray()){
            while(freq[c-'a']>0){
                sb.append(c);
                freq[c-'a']--;
            }
        }
        for(int i=0; i<26; i++){
            int f = freq[i];
            while(f>0){
                sb.append((char)(i+'a'));
                f--;
            }
        }
        return sb.toString();
    }
}