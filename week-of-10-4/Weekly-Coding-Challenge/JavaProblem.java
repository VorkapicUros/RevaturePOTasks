import java.util.Arrays;
import java.util.stream.Stream;

public class JavaProblem {
    public static void main(String[] args) {
        JavaProblem jp = new JavaProblem();
        System.out.println(jp.isValidCard("1234567890123456"));
        System.out.println(jp.isValidCard("1234567890123452"));
    }

    public boolean isValidCard(String s) {
		if (s.length() < 14 || s.length() > 19) return false;
		final int checkDigit = Character.getNumericValue(s.charAt(s.length()-1));
		int[] digarr = Stream.of(s.substring(0, s.length() - 1).split(""))
							 .mapToInt(Integer::parseInt)
							 .toArray();
        int sum = 0;
		for (int i = digarr.length - 1; i >= 0; i--) {
            sum += i % 2 == 1 ? digarr[i] : 
                                digarr[i] < 5 ? digarr[i] * 2 : digarr[i] * 2 - 9; 
		}
		return 10 - sum % 10 == checkDigit;
	}
}