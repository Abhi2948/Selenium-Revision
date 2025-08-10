
//public class CoreJavaBrushUp2 {
//
//    public static void main(String[] args) {
//        int[] arr2 = {11, 22, 33, 44, 55, 66, 77, 88, 12, 13, 14};
//
//        for (int i = 0; i < arr2.length; i++) {
//            if (arr2[i] % 2 == 0) {
//                System.out.println(arr2[i] + " is a multiple of 2");
//            } else {
//                System.out.println(arr2[i] + " is not a multiple of 2");
//            }
//        }
//    }
//}
import java.util.ArrayList;

public class CoreJavaBrushUp_2 {

    public static void main(String[] args) {

        // Create and populate the ArrayList
        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("Abhishek");
        arr1.add("Pramod");
        arr1.add("Sankalp");
        arr1.add("Savita");

        // Print elements using traditional for-loop
        System.out.println("Printing using for loop:");
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));
        }

        // Print elements using enhanced for-loop
        System.out.println("\nPrinting using for-each loop:");
        for (String val : arr1) {
            System.out.println(val);
        }

        // Check if a specific element exists
        String searchItem = "Abhishk3";
        System.out.println("\nDoes the list contain \"" + searchItem + "\"? " + arr1.contains(searchItem));
    }
}
