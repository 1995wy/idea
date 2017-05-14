package com.wangyue.sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 王玥 on 2017/4/20.
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode node){
        ListNode next = null;
        ListNode pre = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            ListNode head,pre = new ListNode(0);
            head = pre;
            while(true) {
                int val = scanner.nextInt();
                if(val==0){
                    break;
                }
                ListNode node = new ListNode(val);
                node.next = null;
                pre.next = node;
                pre = node;
            }
            ListNode b = new ReverseList().reverseList(head.next);
            while(b!=null){
                System.out.println(b.val);
                b = b.next;
            }
        }
    }
}
