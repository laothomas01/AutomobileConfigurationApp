public class Program1 {
    public static void main(String args[]) {
        Program2 p2 = new Program2();
        int counter = 0;
        try {
            p2.test();
        } catch (CustomException ce) {
        } finally {
            System.out.println("In the finally clause");
        }
    }
}
