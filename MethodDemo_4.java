public class MethodDemo_4 {

    public static void main(String[] args) {
        // Creating an object of MethodDemo4
        MethodDemo_4 d = new MethodDemo_4();

        // Calling non-static method multiple times
        System.out.println("1.Calling non-static method multiple times = "+d.getData());
        System.out.println("2.Calling non-static method multiple times = "+d.getData());
        

        // Storing return value from non-static method
        String name = d.getData();
        System.out.println("Storing return value from non-static method = "+name);

        // Creating object of MethodDemo5
        MethodDemo_5 d1 = new MethodDemo_5();
        d1.getUserData();
        System.out.println("Creating object of MethodDemo5 = "+d1.getUserData());

        // Calling static method directly
        getData2();
    }

    // Non-static method returning a String
    public String getData() {
        System.out.println("HELLO_WORLD");
        return "HEllO1";
    }

    // Static method returning a String
    public static String getData2() {
        System.out.println("HELLO_Pateriya");
        return "HEllO2";
    }
}
