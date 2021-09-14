public class JavaProblem {
    public static void main(String[] args) {
        JavaProblem j = new JavaProblem();
        System.out.println("ROT13 of 'Hello' is: " + j.rot13("Hello"));
        System.out.println("7 in Octal is: " + j.decToOct(7));
        System.out.println("8 in Octal is: " + j.decToOct(8));
        System.out.println("80 in Octal is: " + j.decToOct(80));
    }

    public String rot13(String message) {
        message = message.toUpperCase();
        StringBuilder encryption = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                encryption.append(c);
                continue;
            }
            char newC = (char)(c + 13);
            encryption.append(newC > 'Z' ? (char)(newC - 26) : newC);
        }
        return encryption.toString();
    }

    public int decToOct(int num) {
        return Integer.parseInt(Integer.toOctalString(num));
    }

}