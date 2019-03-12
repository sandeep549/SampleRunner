package com.example.ds.tree.binarytreefromtraversal;

import com.example.ds.tree.TreeNode;

/**
 * Construct Binary tree from pre-order and in-order traversal.
 */
class PreInToBinaryTree1 extends BinaryTree {

    int[] pre;
    int[] in;
    int i;

    @Override
    public TreeNode construct(int[] inorder, int[] preorder) {
        this.pre = preorder;
        this.in = inorder;
        this.i = 0;
        return create(0, pre.length - 1);
    }

    private TreeNode create(int start, int end) {
        if (i >= pre.length || start > end) return null;
        TreeNode node = new TreeNode(pre[i++]);
        int nodeIndex = find(node.val, start, end);
        node.left = create(start, nodeIndex - 1);
        node.right = create(nodeIndex + 1, end);
        return node;
    }

    // find key index in inorder
    private int find(int key, int start, int end) {
        for (int j = start; j <= end; j++) {
            if (key == in[j])
                return j;
        }
        return -1; // we must never hit this line.
    }
}
