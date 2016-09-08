package com.morgolt.education.datastructure.trees;

import java.util.function.Consumer;


public class RedBlackTree<K extends Comparable, V> implements IBinaryTree<K, V> {
    private enum Color { RED, BLACK }

    private RedBlackTreeNode root;
    private int count;

    public RedBlackTree() {
        count = 0;
        root = RedBlackTreeNode.NULL_NODE;
    }

    //region insert in tree
    @Override
    @SuppressWarnings("unchecked")
    public void insert(K key, V value) {
        RedBlackTreeNode node = new RedBlackTreeNode(key, value);
        RedBlackTreeNode previous = RedBlackTreeNode.NULL_NODE;
        RedBlackTreeNode current = root;
        while (current != RedBlackTreeNode.NULL_NODE) {
            previous = current;
            if (node.key.compareTo(current.key) < 0)
                current = current.left;
            else if (node.key.compareTo(current.key) > 0)
                current = current.right;
            else {
                current.value = value;
                return;
            }
        }
        node.parent = previous;
        if (previous == RedBlackTreeNode.NULL_NODE)
            root = node;
        else if (node.key.compareTo(previous.key) < 0)
            previous.left = node;
        else
            previous.right = node;
        node.left = RedBlackTreeNode.NULL_NODE;
        node.right = RedBlackTreeNode.NULL_NODE;
        fixInsert(node);
        count++;
    }

    private void fixInsert(RedBlackTreeNode node) {
        while (node.parent.isRed()) {
            boolean isLeft = node.parent == node.parent.parent.left;
            if (isLeft) {
                RedBlackTreeNode uncle = node.parent.parent.right;
                if (uncle.isRed()) {
                    node = caseOne(node, uncle);
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateRight(node.parent.parent);
                }
            }
            else {
                RedBlackTreeNode uncle = node.parent.parent.left;
                if (uncle.isRed()) {
                    node = caseOne(node, uncle);
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    /**
     * Colors node.parent to black, uncle to black and uncle.parent to black.
     * @param node inserted node
     * @param uncle another child of the node.parent.parent
     * @return pointer moved 2 levels up.
     */
    private RedBlackTreeNode caseOne(RedBlackTreeNode node, RedBlackTreeNode uncle) {
        node.parent.color = Color.BLACK;
        uncle.color = Color.BLACK;
        node.parent.parent.color = Color.RED;
        return node.parent.parent;
    }
    //endregion

    //region delete from tree
    @Override
    public void delete(K key) {
        RedBlackTreeNode z = searchNode(key);
        if (z == RedBlackTreeNode.NULL_NODE)
            return;
        Color originalColor = z.color;
        RedBlackTreeNode y;
        RedBlackTreeNode x;

        if (z.left == RedBlackTreeNode.NULL_NODE) {
            x = z.right;
            replace(z, z.right);
        } else if (z.right == RedBlackTreeNode.NULL_NODE) {
            x = z.left;
            replace(z, z.left);
        } else {
            y = getMinimalElement(z.right);
            originalColor = y.color;
            x = y.right;
            if (y.parent == z)
                x.parent = y;
            else {
                replace(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            replace(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (originalColor == Color.BLACK)
            fixDelete(x);
        count--;
    }

    private void fixDelete(RedBlackTreeNode node) {
        while (node != root && !node.isRed()) {
            if (node == node.parent.left) {
                RedBlackTreeNode w = node.parent.right;
                if (w.isRed()) {
                    w.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    rotateLeft(node.parent);
                    w = node.parent.right;
                }
                if (!w.left.isRed() && !w.right.isRed()) {
                    w.color = Color.RED;
                    node = node.parent;
                } else if (!w.right.isRed()) {
                    w.left.color = Color.BLACK;
                    w.color = Color.RED;
                    rotateRight(w);
                    w = node.parent.right;
                }
                w.color = node.parent.color;
                node.parent.color = Color.BLACK;
                w.right.color = Color.BLACK;
                rotateLeft(node.parent);
                node = root;
            } else {
                RedBlackTreeNode w = node.parent.left;
                if (w.isRed()) {
                    w.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    rotateRight(node.parent);
                    w = node.parent.left;
                }
                if (!w.right.isRed() && !w.left.isRed()) {
                    w.color = Color.RED;
                    node = node.parent;
                } else if (!w.left.isRed()) {
                    w.right.color = Color.BLACK;
                    w.color = Color.BLACK;
                    rotateLeft(w);
                    w = node.parent.left;
                }
                w.color = node.parent.color;
                node.parent.color = Color.BLACK;
                w.left.color = Color.BLACK;
                rotateRight(node.parent);
                node = root;
            }
        }
        node.color = Color.BLACK;
    }

    private void replace(RedBlackTreeNode oldNode, RedBlackTreeNode newNode) {
        if (oldNode.parent == RedBlackTreeNode.NULL_NODE)
            root = newNode;
        else if (oldNode == oldNode.parent.left)
            oldNode.parent.left = newNode;
        else
            oldNode.parent.right = newNode;
        if (newNode != RedBlackTreeNode.NULL_NODE)
            newNode.parent = oldNode.parent;
    }
    //endregion

    @Override
    public void infixTraverse(Consumer consumer) {
        infixTraverse(consumer, root);
    }

    @SuppressWarnings("unchecked")
    private void infixTraverse(Consumer consumer, RedBlackTreeNode root) {
        if (root != RedBlackTreeNode.NULL_NODE) {
            infixTraverse(consumer, root.left);
            consumer.accept(root.value);
            infixTraverse(consumer, root.right);
        }
    }

    private void rotateLeft(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        x.right = y.left;
        if (y.left != RedBlackTreeNode.NULL_NODE)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == RedBlackTreeNode.NULL_NODE)
            this.root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.left;
        x.left = y.right;
        if (y.right != RedBlackTreeNode.NULL_NODE)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == RedBlackTreeNode.NULL_NODE)
            this.root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V search(K key) {
        return (V) searchNode(key).value;
    }

    @Override
    public boolean contains(K key) {
        return searchNode(key) != RedBlackTreeNode.NULL_NODE;
    }

    @Override
    public int getCount() {
        return count;
    }

    @SuppressWarnings("unchecked")
    private RedBlackTreeNode searchNode(K key) {
        RedBlackTreeNode result = root;
        while (result != RedBlackTreeNode.NULL_NODE) {
            if (key.compareTo(result.key) == 0)
                break;
            if(key.compareTo(result.key) > 0)
                result = result.right;
            else
                result = result.left;
        }
        return result;
    }

    private RedBlackTreeNode getMinimalElement(RedBlackTreeNode node) {
        while(node.left != RedBlackTreeNode.NULL_NODE)
            node = node.left;
        return node.left;
    }

    @SuppressWarnings("unchecked")
    private static class RedBlackTreeNode<K extends Comparable, V> {
        static final RedBlackTreeNode NULL_NODE = new RedBlackTreeNode(null, null);
        static { NULL_NODE.color = Color.BLACK; }

        private K key;
        private V value;
        private RedBlackTreeNode right;
        private RedBlackTreeNode left;
        private Color color = Color.RED;
        private RedBlackTreeNode parent;

        private RedBlackTreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private boolean isRed() {
            return this.color == Color.RED;
        }
    }
}
