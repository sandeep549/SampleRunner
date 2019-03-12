package com.example.ds.tree.binarytreefromtraversal;

import com.example.ds.tree.TreeNode;

/**
 * Construct Binary tree from post-order and in-order traversal.
 */
class PostInToBinaryTree1 extends BinaryTree {

    int[] post;
    int[] in;
    int postIndex;

    @Override
    public TreeNode construct(int[] inorder, int[] postorder) {
        this.post = postorder;
        this.in = inorder;
        this.postIndex = post.length - 1;
        return create(0, post.length - 1);
    }

    private TreeNode create(int start, int end) {
        if (postIndex < 0 || start > end) return null;
        TreeNode node = new TreeNode(post[postIndex--]);
        int nodeIndex = find(node.val, start, end);
        node.right = create(nodeIndex + 1, end);
        node.left = create(start, nodeIndex - 1);
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
