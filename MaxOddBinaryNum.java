class Solution {
    public String maximumOddBinaryNumber(String s) {
        char arr [] = s.toCharArray();

        int ones = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '1'){
                arr[i] = '0';
                ones++;
            }
        }

        if(ones > 1){
            for(int i=0;i<ones-1;i++){
                arr[i] = '1';
            }
        }            
        arr[arr.length-1] = '1';
        return new String(arr);
    }
}
