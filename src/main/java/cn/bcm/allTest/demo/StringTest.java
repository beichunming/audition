package cn.bcm.allTest.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StringTest
 * @Author beichunming
 * @Date 2018/11/21 下午12:14
 */
public class StringTest {

    public static void main(String[] args) {

        String k = test1();
        System.out.println(k);
        String string = test2();
        System.out.println(string);
    }

    public static String test1(){
        String str = "abcdefcef";
        Map<String,Integer>map = new HashMap<>();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            String k = String.valueOf(c);
            Integer v = map.get(k);
            if (v==null){
                map.put(k,1);
            }else {
                return k;
            }
        }
        return null;
    }

    public static String test2(){

        String str = "aaabbbbccdddddee";
        StringBuilder stringBuilder = new StringBuilder("");
        Map<String,Integer>map = new HashMap<>();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            String k = String.valueOf(c);
            Integer v = map.get(k);
            if (v==null){
                map.put(k,1);
            }else {
                map.put(k,++v);
            }
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
