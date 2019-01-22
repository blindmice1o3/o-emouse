package tinker;

public class TestCallingMainMethod {

    String[] feedMe = { "cat", "dog", "mouse" };
    static int count = 2;

    public static void main(String[] args) {

        System.out.println("**** main(String[]) being called ****");

        count--;

        if (count >= 0) {
            TestCallingMainMethod test = new TestCallingMainMethod();
            test.callMainMethod();
        }

    } // **** end main(String[]) ****

    public void callMainMethod() {

        System.out.println("++ callMainMethod() being called ++");

        System.out.println("| count: " + count + " |");

        main(feedMe);

    } // **** end callMainMethod() ****

}
