package com.wangyue.sf;



import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 王玥 on 2017/4/26.
 */
public class ArrayOrder {

    public void reOrderArray(int [] array){
        if(array.length<=0){
            return ;
        }

        int newArray[] = new int[array.length];
        int count = 0;
        for(int i=0; i<array.length; i++){
            if((array[i]&1)==1)
                count++;
        }
        int j=0;
        for(int i=0; i<array.length; i++){
            if((array[i]&1)!=1){
                newArray[count++] = array[i];
            }else{
                newArray[j++] = array[i];
            }
        }
        for(int i=0; i<array.length; i++){
            array[i] = newArray[i];
        }

    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null||list2==null){
            return list1==null? list2:list1;
        }
        ListNode pre = null;
        ListNode head = list1.val <= list2.val? list1 : list2;
        if(head==list1){
            list1 = list1.next;
        }else{
            list2 = list2.next;
        }
        ListNode cur = head;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                pre = list1;
                list1 = list1.next;
            }else{
                pre  = list2;
                list2 = list2.next;
            }
            cur.next= pre;
            cur = pre;
        }
        cur.next = list1 == null? list2 :list1;
        return head;
    }
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()<=0){
            return -1;
        }
        ArrayList<Character> list = new ArrayList<Character>();
        for(char c : str.toCharArray()){
            if(!list.contains(c)){
                list.add(c);
            }else{
                list.add(Character.valueOf(c));
            }
        }
        if(list.size()<1){
            return -1;
        }
        return str.indexOf(list.get(0).toString());
    }
    public int getFirst(int [] array , int k, int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid]<k){
            return getFirst(array,k,mid+1,end);
        }else if(array[mid]>k){
            return getFirst(array,k,start,mid-1);
        }else if(mid-1>=0&&array[mid-1]==k){
            return getFirst(array,k,start,mid-1);
        }else{
            return mid;
        }
    }
    public int getLast(int [] array , int k, int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid]<k){
            return getLast(array,k,mid+1,end);
        }else if(array[mid]>k){
            return getLast(array,k,start,mid-1);
        }else if(mid+1<array.length&&array[mid+1]==k){
            return getLast(array,k,mid+1,end);
        }else{
            return mid;
        }
    }
    public static void main(String[] args) {
        int array[] = {1,2,4,3,5};
        int array1[] = {1,2,3,3,3,3,4,5};
        int flag = 1;
        System.out.println(new ArrayOrder().getLast(array1,3,0,array1.length));
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        LinkedList queue = new LinkedList();
       /* new ArrayOrder().reOrderArray(array);
        for(int i : array){
            System.out.println(i);
        }*/

       /*ListNode head = new ArrayOrder().Merge(list1,list2);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }*/
    }
}
 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
