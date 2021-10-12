import java.util.*;
import java.lang.Math.*;

public class JavaProblems {
    public static void main(String[] args) {
        JavaProblems jp = new JavaProblems();

        // HashMap Iteration
        HashMap<Integer, String> someMap = jp.generateRandomMap(10);
        jp.whileHashMapIterator(someMap);
        System.out.println();
        jp.forHashMapIterator(someMap);
        System.out.println();

        //String Rotation Checker
        String a = "dabc", b = "abcd", c = "dbac";
        System.out.println(a + " is a rotation of " + b + ": " + jp.isRotatedString(a, b));
        System.out.println(a + " is a rotation of " + c + ": " + jp.isRotatedString(a, c));
    }

    public <K, V> void whileHashMapIterator(HashMap<K, V> hmap) {
        Iterator it = hmap.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public <K, V> void forHashMapIterator(HashMap<K, V> hmap) {
        for (Map.Entry<K, V> entry : hmap.entrySet()) {
            System.out.println(entry);
        }
    }

    public boolean isRotatedString(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.equals(b)) return true;
            a = a.substring(1, a.length()) + a.substring(0, 1);
        }
        return false;
    }

    private HashMap<Integer, String> generateRandomMap(int size) {
        HashMap<Integer, String> map = new HashMap<>();
        int powSize = size*size;
        for (int i = 0; i < size; i++) {
            if (map.putIfAbsent((int) (Math.random() * powSize), randString(size)) != null) {
                i--;
            }
        }
        return map;
    }

    private String randString(int length) {
        int left = 48, right = 123, diff = right - left;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append((char) ((int) (Math.random() * diff + left)));
        }
        return sb.toString();
    }
}
