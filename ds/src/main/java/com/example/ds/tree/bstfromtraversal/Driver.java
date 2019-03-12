package com.example.ds.tree.bstfromtraversal;

import com.example.ds.tree.TreeNode;

public class Driver {

    public static void main(String[] args) {
        int post[] = new int[]{1, 7, 5, 50, 40, 10};
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        //int post[] = new int[]{8,7,6,50,40,10};
        Bst bst = new Bst();

        TreeNode root = null;

        System.out.println("From Postorder...1");
        root = bst.constructBstFromPostOrder_1(post);
        bst.printInorder(root);

        System.out.println("From Postorder...2");
        root = bst.constructBstFromPostOrder_2(post);
        bst.printInorder(root);

        System.out.println("From Postorder...3");
        root = bst.constructBstFromPostOrder_3(post);
        bst.printInorder(root);

        System.out.println("From Postorder...4");
        root = bst.constructBstFromPostOrder_4(post);
        bst.printInorder(root);

        System.out.println("From Preorder...1");
        root = bst.constructBstFromPreOrder_1(pre);
        bst.printInorder(root);

        System.out.println("From Preorder...2");
        root = bst.constructBstFromPreOrder_2(pre);
        bst.printInorder(root);

        System.out.println("From Preorder...3");
        root = bst.constructBstFromPreOrder_3(pre);
        bst.printInorder(root);

        System.out.println("From Preorder...4");
        root = bst.constructBstFromPreOrder_4(pre);
        bst.printInorder(root);

    }
}