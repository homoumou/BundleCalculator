import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of posts");
        int postNums = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter format code");
        String formatCode = scanner.nextLine();
        Order order = new Order();
        order.setPostNums(postNums);
        order.setFormatCode(formatCode);
        order.calculate();

    }
}
