package com.wangyue.sf;

import java.util.Scanner;

/**
 * Created by 王玥 on 2017/4/15.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            StringBuffer  s1 = new StringBuffer();
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c==' '){
                    s1.append("%20");
                }else{
                    s1.append(c);
                }
            }
            System.out.println(s1.toString());
        }
    }
}
