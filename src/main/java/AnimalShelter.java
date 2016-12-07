import java.util.LinkedList;

/**
 * Created by shuaiwang on 11/2/16.
 */
public class AnimalShelter {
    int timestamp;
    LinkedList<String> dogs, cats;

    private String getName(String animal) {
        return animal.substring(animal.indexOf("#") + 1, animal.length());
    }

    private int getTime(String animal) {
        return Integer.parseInt(animal.substring(0, animal.indexOf("#")));
    }

    public AnimalShelter() {
        // do initialize if necessary
        timestamp = 0;
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        timestamp++;
        if (type == 0) {
            cats.add(timestamp + "#" + name);
        } else {
            dogs.add(timestamp + "#" + name);
        }
    }

    public String dequeueAny() {
        // Write your code here
        if (dogs.isEmpty()) {
            return dequeueCat();
        }

        if (cats.isEmpty()) {
            return dequeueDog();
        }

        int lastDog = getTime(dogs.getFirst());
        int lastCat = getTime(cats.getFirst());
        if (lastDog < lastCat) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public String dequeueDog() {
        // Write your code here
        if (dogs.isEmpty()) {
            return "";
        } else {
            return getName(dogs.removeFirst());
        }
    }

    public String dequeueCat() {
        // Write your code here
        if (cats.isEmpty()) {
            return "";
        } else {
            return getName(cats.removeFirst());
        }
    }

    public static void main(String[] args) {
        AnimalShelter test = new AnimalShelter();

        test.enqueue("james", 1);
        test.enqueue("tom", 1);
        test.enqueue("mimi", 0);
        test.dequeueAny();
        test.dequeueCat();
        test.dequeueDog();
    }
}
