package G;

import java.util.*;

public class DogRelation {
    class Dog {
        List<Dog> parents;
        Dog(Dog father, Dog mother) {
            parents = new ArrayList<>();
            parents.add(father);
            parents.add(mother);
        }
    }

    public boolean dogRelation(Dog a, Dog b) {
        Queue<Dog> qa = new LinkedList<>();
        Queue<Dog> qb = new LinkedList<>();

        Set<Dog> setA = new HashSet<>();
        Set<Dog> setB = new HashSet<>();


        qa.offer(a);
        qb.offer(b);
        setA.add(a);
        setB.add(b);

        int limit = 20;
        while (limit >= 0 && !qa.isEmpty() && !qb.isEmpty()) {
            int sizeA = qa.size();
            while (sizeA >= 0) {
                Dog d = qa.poll();
                if (setB.contains(d)) {
                    return true;
                }
                List<Dog> tmp = d.parents;
                qa.offer(tmp.get(0));
                setA.add(tmp.get(0));
                qa.offer(tmp.get(1));
                setA.add(tmp.get(1));
                sizeA--;
            }

            int sizeB = qb.size();
            while (sizeB >= 0) {
                Dog d = qb.poll();
                if (setA.contains(d)) {
                    return true;
                }
                List<Dog> tmp = d.parents;
                qb.offer(tmp.get(0));
                setB.add(tmp.get(0));
                qb.offer(tmp.get(1));
                setB.add(tmp.get(1));
                sizeB--;
            }

            limit--;
        }
        return false;
    }
}
