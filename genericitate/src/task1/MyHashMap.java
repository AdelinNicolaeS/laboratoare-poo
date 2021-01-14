package task1;

import java.util.ArrayList;
import java.util.Comparator;

public class MyHashMap<K, V> {
    ArrayList<MyEntry<K, V>> table = new ArrayList<>();

    public class MyEntry<K, V> {
        K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(K key, V value, MyEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public MyEntry() {
        }

    }
    public V put(K k, V v) {
        MyEntry<K, V> entry = new MyEntry<>(k, v, null);
        int ok = 0;
        for (MyEntry<K, V> myEntry : table) {
            if (myEntry.key.equals(entry.key)) {
                myEntry.value = entry.value;
                ok = 1;
            }
        }
        if(ok == 0) {
            table.add(entry);
        }
        table.sort(Comparator.comparingInt(t -> t.key.hashCode()));
        return entry.value;
    }
    public V get(K k) {
        for(MyEntry<K, V> myEntry : table) {
            if (myEntry.key.equals(k)) {
                return myEntry.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for(MyEntry<K, V> myEntry : table) {
            output.append(myEntry.key).append("=").append(myEntry.value).append(", ");
        }
        if (output.length() > 2) {
            output.setLength(output.length() - 2);
        }
        output.append("}");
        return output.toString();
    }
}
