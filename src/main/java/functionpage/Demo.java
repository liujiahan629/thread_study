package functionpage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    private int a = 1;

    public void testMethod() {
        System.out.println(a);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int sLength = s.length();
        int pLength = p.length();
        //如果长度没有p的，直接返回空
        if(sLength<pLength){
            return result;
        }
        //利用数组的Assic码进行标识，字母出现的情况
        int[] temp = new int[26];
        //目标比较数组
        for(char pChar : p.toCharArray()){
            temp[pChar - 'a'] =1;
        }
        int counter = pLength;
        char[] ss = s.toCharArray();
        int left = 0;
        int right = 0;
        while(right<sLength){
            int rem=temp[ss[right] - 'a']--;
            if( rem== 0){
                counter -- ;
            }
            right ++;
            if(counter == 0){
                result.add(left);
            }
            if(right - left == pLength){
                if(temp[ss[left]-'a']++ == 1){
                    counter ++;
                }
                left ++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("abab","ab");
    }
}
