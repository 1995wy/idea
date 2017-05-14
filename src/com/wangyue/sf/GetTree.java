package com.wangyue.sf;

import java.util.HashMap;

/**
 * Created by 王玥 on 2017/4/22.
 */
public class GetTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public TreeNode getTree(int [] pre,int start1,int end1,int [] in, int start2,int end2,
                            HashMap<Integer,Integer> map){
        if(start1>end1){
            return null;
        }
        TreeNode head = new TreeNode(pre[start1]);
        int index = map.get(pre[start1]);
        head.left = getTree(pre,start1+1,start1+index-start2,in,start2,index-1,map);
        head.right = getTree(pre,start1+index-start2+1,end1,in,index+1,end2,map);
        return head;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null){
            return null;
        }
        HashMap<Integer,Integer>  map = new HashMap<Integer,Integer> ();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return getTree(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    public static void main(String[] args) {
        int []pre = {1,2,4,7,3,5,6,8};
        int []in = {4,7,2,1,5,3,8,6};
        System.out.println(new GetTree().reConstructBinaryTree(pre,in));
    }
}
