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
    }
}
