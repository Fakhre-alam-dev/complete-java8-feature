package mfa.codecurve.streamapi;

public class FindFirstRepetitiveCharacter {

    public static void main(String[] args) {
        String str="japan";

        Character character = str.chars().mapToObj(c -> (char) c)
                .filter(s -> str.indexOf(s) != str.lastIndexOf(s)).distinct().findFirst().get();
        System.out.println(character);
    }

}
