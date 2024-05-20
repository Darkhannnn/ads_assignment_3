import java.util.LinkedList;
import java.util.Queue;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
    public int size(){
        return size;
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    private Node put(Node current, K key, V val){
        if (current == null){
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left  = put(current.left,  key, val);
        }
        else if (cmp > 0) {
            current.right = put(current.right, key, val);
        }
        else {
            current.val = val;
        }
        return current;
    }
    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            }
            else if (cmp > 0) {
                x = x.right;
            }
            else {
                return x.val;
            }
        }
        return null;
    }
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            size--;
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            Node temp = current;
            current = min(temp.right);
            current.right = deleteMin(temp.right);
            current.left = temp.left;
        }
        return current;
    }

    private Node min(Node current) {
        if (current.left == null) return current;
        else return min(current.left);
    }

    private Node deleteMin(Node current) {
        if (current.left == null) return current.right;
        current.left = deleteMin(current.left);
        return current;
    }

    public Iterable<K> iterator() {
        Queue<K> keys = new LinkedList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node current, Queue<K> keys) {
        if (current != null) {
            inOrder(current.left, keys);
            keys.add(current.getKey());
            inOrder(current.right, keys);
        }
    }

}