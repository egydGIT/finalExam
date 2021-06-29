package hu.nive.ujratervezes.lettermultiplier;

public class LetterMultiplier {


    public String multiply(String input, int number) {
        if (input == null || input.isBlank() || input.equals("")) {
            throw new IllegalArgumentException("Wrong param: " + input);
        }
        if (number < 0 ) {
            throw new IllegalArgumentException("Wrong param: " + number);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String s = Character.toString(input.charAt(i)).repeat(number);
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LetterMultiplier letterMultiplier = new LetterMultiplier();
        String s = letterMultiplier.multiply("java", 3);
        System.out.println(s);
    }
}
