package task1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "ana");
        hashMap.put(5, "pere");
        System.out.println(hashMap);
        hashMap.put(5, "corcoduse");
        System.out.println(hashMap);
        hashMap.put(3, "bogdan");
        System.out.println(hashMap);
        System.out.println(hashMap.put(5, "corcoduse"));
        System.out.println("------------------------");
        MyHashMap<Integer, String> myhashMap = new MyHashMap<>();
        myhashMap.put(1, "ana");
        myhashMap.put(5, "pere");
        System.out.println(myhashMap);
        myhashMap.put(5, "corcoduse");
        System.out.println(myhashMap);
        myhashMap.put(3, "bogdan");
        System.out.println(myhashMap);
        System.out.println(myhashMap.put(5, "corcoduse"));
    }
}
