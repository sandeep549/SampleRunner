package com.example.ds.tree.binarytreefromtraversal;

import com.example.ds.tree.TreeNode;

abstract class BinaryTree {

    public abstract TreeNode construct(int[] inorder, int[] arr);

    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }
}
