package com.example.ds.tree.bstfromtraversal;

import com.example.ds.tree.TreeNode;

import java.util.Stack;

class Bst {

    int[] arr;
    int i;

    public Bst() {
    }

    //**************************************************************************
    // Construct BST from post-order traversal
    //**************************************************************************

    //**************************************
    // 1.
    //**************************************
    public TreeNode constructBstFromPostOrder_1(int[] post) {
        this.arr = post;
        i = arr.length - 1;
        return bstFromPostOrder_1(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPostOrder_1(int minVal, int maxVal) {
        if (i < 0) return null;
        TreeNode root = null;
        if (arr[i] > minVal && arr[i] < maxVal) {
            root = new TreeNode(arr[i--]);
            root.right = bstFromPostOrder_1(root.val, maxVal);
            root.left = bstFromPostOrder_1(minVal, root.val);
        }
        return root;
    }

    //**************************************
    // 2.
    //**************************************

    public TreeNode constructBstFromPostOrder_2(int[] post) {
        this.arr = post;
        return bstFromPostOrder_2(0, arr.length - 1);
    }

    private TreeNode bstFromPostOrder_2(int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        TreeNode root = new TreeNode(arr[endIndex]);
        int i = endIndex - 1;
        while (i >= startIndex && arr[i] > root.val) {
            i--;
        }
        root.left = bstFromPostOrder_2(startIndex, i);
        root.right = bstFromPostOrder_2(i + 1, endIndex - 1);
        return root;
    }

    //**************************************
    // 3.
    //**************************************

    public TreeNode constructBstFromPostOrder_3(int[] post) {
        this.arr = post;
        return bstFromPostOrder_3(0, arr.length - 1);
    }

    private TreeNode bstFromPostOrder_3(int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(arr[end]);
        int i = findLastSmaller(arr, start, end - 1, root.val);
        root.left = bstFromPostOrder_3(start, i);
        root.right = bstFromPostOrder_3(i + 1, end - 1);
        return root;
    }

    private int findLastSmaller(int[] nodes, int first, int last, int cut) {
        if (last < first || nodes[first] > cut) return first - 1;
        int low = first, high = last, mid;
        while (low < high && nodes[high] > cut) {
            mid = low + (high - low + 1) / 2;
            if (nodes[mid] > cut) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high;
    }

    //**************************************
    // 4.
    //**************************************
    public TreeNode constructBstFromPostOrder_4(int[] arr) {
        Stack<TreeNode> s = new Stack<>();
        int i = arr.length - 1;
        TreeNode root = new TreeNode(arr[i]);
        s.push(root);
        while (--i >= 0) {
            TreeNode x = new TreeNode(arr[i]);
            TreeNode tmp = null;
            while (!s.isEmpty() && arr[i] < s.peek().val)
                tmp = s.pop();
            if (tmp == null) {
                s.peek().right = x;
            } else {
                tmp.left = x;
            }
            s.push(x);
        }
        return root;
    }

    //******************************************************
    // Construct BST from pre-order traversal
    //******************************************************

    //**************************************
    // 1.
    //**************************************
    public TreeNode constructBstFromPreOrder_1(int[] pre) {
        this.arr = pre;
        this.i = 0;
        return bstFromPreOrder_1(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreOrder_1(int minVal, int maxVal) {
        if (i >= arr.length) return null;
        TreeNode root = null;
        if (arr[i] > minVal && arr[i] < maxVal) {
            root = new TreeNode(arr[i++]);
            root.left = bstFromPreOrder_1(minVal, root.val);
            root.right = bstFromPreOrder_1(root.val, maxVal);
        }
        return root;
    }

    //**************************************
    // 2.
    //**************************************

    public TreeNode constructBstFromPreOrder_2(int[] pre) {
        this.arr = pre;
        return bstFromPreOrder_2(0, arr.length - 1);
    }

    private TreeNode bstFromPreOrder_2(int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        TreeNode root = new TreeNode(arr[startIndex]);
        int i = startIndex + 1;
        while (i <= endIndex && arr[i] < root.val) {
            i++;
        }
        root.left = bstFromPreOrder_2(startIndex + 1, i - 1);
        root.right = bstFromPreOrder_2(i, endIndex);
        return root;
    }

    //**************************************
    // 3.
    //**************************************

    public TreeNode constructBstFromPreOrder_3(int[] pre) {
        this.arr = pre;
        return bstFromPreOrder_3(0, arr.length - 1);
    }

    private TreeNode bstFromPreOrder_3(int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(arr[start]);
        int i = findFirstGreater(arr, start + 1, end, root.val);
        root.left = bstFromPreOrder_3(start + 1, i - 1);
        root.right = bstFromPreOrder_3(i, end);
        return root;
    }

    private int findFirstGreater(int[] nodes, int first, int last, int cut) {
        if (last < first || nodes[last] < cut) return last + 1;
        int low = first, high = last, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nodes[mid] > cut) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    //**************************************
    // 4.
    //**************************************
    public TreeNode constructBstFromPreOrder_4(int[] arr) {
        Stack<TreeNode> s = new Stack<>();
        int i = 0;
        TreeNode root = new TreeNode(arr[i]);
        s.push(root);
        while (++i < arr.length) {
            TreeNode x = new TreeNode(arr[i]);
            TreeNode tmp = null;
            while (!s.isEmpty() && arr[i] > s.peek().val)
                tmp = s.pop();
            if (tmp == null) {
                s.peek().left = x;
            } else {
                tmp.right = x;
            }
            s.push(x);
        }
        return root;
    }

    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }
}
