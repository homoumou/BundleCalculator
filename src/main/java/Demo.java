import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
       ReadInput read = new ReadInput();
       String file = "src/main/java/input.txt";
       read.readInput(file);
       Order order = new Order();
       order.setItems(file);
       order.calculate();
    }
}
