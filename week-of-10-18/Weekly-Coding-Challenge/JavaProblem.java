public class JavaProblem {
    public static void main(String[] args) {
        JavaProblem jp = new JavaProblem();
        System.out.println(jp.atbash("apple"));
        System.out.println(jp.atbash("Hello world!"));
        System.out.println(jp.atbash("Christmas is the 25th of December"));
    }

    public char flip (char c) {
        if (c < 65 || c > 90 && c < 97 || c > 122) return c;
        int startPoint = Character.isUpperCase(c) ? (int) 'A' : (int) 'a';
        int numC = (int) c - startPoint;
        return (char) (startPoint + (25 - numC));
    }

    public String atbash(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(flip(c));
        }
        return sb.toString();
    }
}