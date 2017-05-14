package com.wangyue.sf;

/**
 * Created by 王玥 on 2017/4/22.
 */
public class ReverseArray {
    public void reverse(int [] array,int b, int e){
        while(b<e){
            int temp = array[e];
            array[e] = array[b];
            array[b] = temp;
            b++;
            e--;
        }
    }
    public int JumpFloorII(int target) { // 跳台阶问题
        if(target<1){
            return 0;
        }
        if(target==1){
            return 1;
        }
        int n = 0;
        while((target--)>=1){
            n += JumpFloorII(target);
        }
        return n+1;
    }
    public int minNumberInRotateArray(int [] array) {
        if(array.length<=0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j<array.length; j++){
            if(array[j]<array[j-1]){
                i = j;
            }
        }
        if(i==0){
            return array[0];
        }else{
            reverse(array,i,array.length-1);
            reverse(array,0,i);
            reverse(array,0,array.length-1);
        }
        return array[0];
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        //System.out.println(new ReverseArray().minNumberInRotateArray(array));
        System.out.println(new ReverseArray().JumpFloorII(5));

    }
}
