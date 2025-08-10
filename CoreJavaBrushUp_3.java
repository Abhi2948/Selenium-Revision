import java.util.ArrayList;

public class CoreJavaBrushUp_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // String literals (commented out)
        // String str1 = "Abhishek Pateriya";
        // String str2 = "Abhishek Pateriya";

        // String objects created using new keyword
        String str3 = new String("Welcome");
        String str4 = new String("Welcome");

        String str1 = "Abhishek Pramod Pateriya";

        // Splitting the string using "Pramod" as the delimiter
        String[] splittedString = str1.split("Pramod");

        System.out.println(splittedString[0]);         // Output before "Pramod"
        System.out.println(splittedString[1]);         // Output after "Pramod"
        System.out.println(splittedString[1].trim());  // Trimmed output after "Pramod"

        // Printing string in reverse
        for (int i = str1.length() - 1; i >= 0; i--) {
            System.out.println(str1.charAt(i));
        }
    }
}
