class Solution {
    public String largestPalindromic(String num) {
        char[] ch = num.toCharArray();
        int n = ch.length;
        int[] hash = new int[10];
        for(int i = 0 ; i < n ; i++){
            hash[ch[i] - '0']++;
        }
        if(hash[0] == n){
            return "0";
        }
        StringBuilder first = new StringBuilder();
        char middle = 'a';
        boolean middle_flag = true;
        for(int i = 9 ; i >= 0 ; i--){
            if(middle_flag && hash[i] % 2 != 0){
                middle_flag = false;
                middle = (char)(i + '0');
            }
            int freq = hash[i] / 2;
            while(freq-- > 0){
                first.append(i);
            }
        }
        if(first.length() > 0 && first.charAt(0) == '0'){
            return String.valueOf(middle);
        }
        StringBuilder last = new StringBuilder(first);
        if(!middle_flag){
            first.append(middle);
        }
        first.append(last.reverse());
        return new String(first);
    }
}
