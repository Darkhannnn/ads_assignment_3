public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key){
        return key.hashCode() % M;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null){
            chainArray[index] = newNode;
        }else {
            HashNode<K, V> currentNode = chainArray[index];
            while (currentNode != null){
                if (currentNode.key.equals(key)){
                    currentNode.value = value;
                    return;
                }
                if (currentNode.next == null) {
                    break;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        size++;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];

        while (currentNode != null){
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        HashNode<K, V> prevNode = null;

        while (currentNode != null){
            if (currentNode.key.equals(key)) {
                chainArray[index] = currentNode.next;
                if (prevNode == null){
                    chainArray[index] = currentNode.next;
                }else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(V value){
//        for (int i = 0; i < M; i++) {
//            HashNode<K, V> currentNode = chainArray[i];
//            while (currentNode != null){
//                if (currentNode.value.equals(value)){
//                    return true;
//                }
//                currentNode = currentNode.next;
//            }
//        }

        if (getKey(value) != null){
            return true;
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null){
                if (currentNode.value.equals(value)){
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    public int totalElements(){
        int count = 0;
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }
        }
        return count;
    }
}
