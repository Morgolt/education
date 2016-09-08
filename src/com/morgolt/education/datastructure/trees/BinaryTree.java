package com.morgolt.education.datastructure.trees;

import java.util.function.Consumer;

public class BinaryTree<K extends Comparable, V> implements IBinaryTree<K, V> {

    private BinaryTreeNode root;
    private int count;


    //region insert methods
    @Override
    @SuppressWarnings("unchecked")
    public void insert(K key, V value) {
        if (root == null) {
            root = new BinaryTreeNode(key, value);
        } else {
            recursiveInsert(root, new BinaryTreeNode(key, value));
        }
        count++;
    }

    @SuppressWarnings("unchecked")
    private void recursiveInsert(BinaryTreeNode root, BinaryTreeNode newNode) {
        int result = root.key.compareTo(newNode.key);
        if (result > 0) {
            if (root.left == null)
                root.left = newNode;
            else
                recursiveInsert(root.left, newNode);
        } else if (result < 0) {
            if (root.right == null)
                root.right = newNode;
            else
                recursiveInsert(root.right, newNode);
        }
        // in case of equal keys just replace the value
        else {
            root.value = newNode.value;
            count--;
        }
    }
    //endregion

    @Override
    @SuppressWarnings("unchecked")
    public void delete(K key) {
        BinaryTreeNode parent = null;
        BinaryTreeNode current = root;
        boolean isLeftChild = false;
        while (current.key.compareTo(key) != 0) {
            parent = current;
            int result = current.key.compareTo(key);
            if (result > 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return;
        }

        count--;

        // no childes case
        if (current.left == null && current.right == null) {
            if (current.equals(root))
                root = null;
            if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
            // only left child case
        } else if (current.right == null) {
            if (current.equals(root))
                root = current.left;
            else if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
            // only right child case
        } else if (current.left == null) {
            if (current.equals(root))
                root = current.right;
            else if (isLeftChild)
                parent.left = current.right;
            else
                parent.left = current.right;
        }
        // both childes case
        else {
            BinaryTreeNode leftmost = current.right.left;
            BinaryTreeNode leftmostParent = current.right;

            while (leftmost.left != null) {
                leftmostParent = leftmost;
                leftmost = leftmost.left;
            }

            // left subtree becomes right subtree of leftmost node
            leftmostParent.left = leftmost.right;

            //left and right childes of current node becomes
            //left and right childes of leftmost node
            leftmost.left = current.left;
            leftmost.right = current.right;

            if (parent == null)
                root = leftmost;
            else {
                int result = parent.key.compareTo(current.key);
                if (result > 0) {
                    parent.left = leftmost;
                }
                else if (result < 0) {
                    parent.right = leftmost;
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V search(K key) {
        return (V) findNode(key).value;
    }

    /**
     * Infix infixTraverse of the tree.
     * @param consumer - function to apply to each node value
     */
    @Override
    public void infixTraverse(Consumer consumer) {
        infixTraverse(consumer, root);
    }

    @SuppressWarnings("unchecked")
    private void infixTraverse(Consumer consumer, BinaryTreeNode root) {
        if (root != null) {
            infixTraverse(consumer, root.left);
            consumer.accept(root.value);
            infixTraverse(consumer, root.right);
        }
    }
    //endregion

    @Override
    public boolean contains(K key) {
        return findNode(key) != null;
    }

    @Override
    public int getCount() {
        return count;
    }

    @SuppressWarnings("unchecked")
    private BinaryTreeNode findNode(K key) {
        BinaryTreeNode current = root;
        while (current != null) {
            int result = current.key.compareTo(key);
            if (result > 0)
                current = current.left;
            else if (result < 0)
                current = current.right;
            else
                break;
        }
        return current;
    }

    private static class BinaryTreeNode<K extends Comparable, V> {
        private final K key;
        private V value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        private BinaryTreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
