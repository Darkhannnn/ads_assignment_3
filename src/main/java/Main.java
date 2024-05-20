import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000), random.nextInt(1000));
            table.put(key, "Value" + i);
        }
        table.printBucketSizes();

        System.out.println("Total number of elements: " + table.totalElements());



        BST<Integer, String> bst = new BST<>();

        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(2, "two");
        bst.put(4, "four");
        bst.put(6, "six");
        bst.put(8, "eight");

        System.out.println("Get 3: " + bst.get(3)); // "three"
        System.out.println("Get 6: " + bst.get(6)); // "six"
        System.out.println("Get 10: " + bst.get(10)); // null

        System.out.println("Keys in order:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }

        bst.delete(3);
        System.out.println("After deleting key 3:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }

        bst.delete(7);
        System.out.println("After deleting key 7:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
    }
}

