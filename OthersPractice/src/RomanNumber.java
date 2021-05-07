/**
 * turn Roman number to integer
 */
public class RomanNumber {
    public static void main(String[] args){
        System.out.println(romanToInt("IV"));
        System.out.println(intToRoman(671));

    }

    public static int romanToInt(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1; i< s.length(); i++){
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else{
                sum += preNum;
            }
            preNum = num;
        }

        sum += preNum;
        return sum;
    }

    public static String intToRoman(int num){
        int[] values = {1000, 900, 500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder cur = new StringBuilder();
        for(int i = 0; i< values.length && num >=0; i++){
            while(values[i] <= num){
                num -=values[i];
                cur.append(symbols[i]);
            }
        }

        return cur.toString();

    }

    private static int getValue(char ch){
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
