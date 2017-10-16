package fb;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {


    class StringClass {
        StringBuilder sb;
        public StringClass(String s) {
            sb = new StringBuilder(s);
        }

        public void write(String s) {
            this.sb = new StringBuilder(s);
        }
    }

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(1);
        CopyOnWriteArrayList<Integer> list2 = list1;

        list1.add(2);

        System.out.println(list1);

    }
}
