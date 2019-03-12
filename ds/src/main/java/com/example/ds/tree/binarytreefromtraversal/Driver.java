package com.example.ds.tree.binarytreefromtraversal;

import com.example.ds.tree.TreeNode;

public class Driver {

    public static void main(String[] args) {

        int postorder[] = new int[]{9, 15, 7, 20, 3};
        int preorder[] = new int[]{3, 9, 20, 15, 7};
        int inorder[] = new int[]{9, 3, 15, 20, 7};

        TreeNode root = null;
        BinaryTree binaryTree = new PreInToBinaryTree1();
        System.out.println("From Preorder+Inorder...Method-1");
        root = binaryTree.construct(inorder, preorder);
        binaryTree.printInorder(root);

        binaryTree = new PostInToBinaryTree1();
        System.out.println("From Postorder+Inorder...Method-1");
        root = binaryTree.construct(inorder, postorder);
        binaryTree.printInorder(root);

    }
}