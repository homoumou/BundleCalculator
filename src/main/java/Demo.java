import java.io.IOException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException {
        ReadInput read = new ReadInput();
        WriteOutput write = new WriteOutput();
        String file = "src/main/java/input.txt";
        read.readInput(file);
        Order order = new Order();
        order.setItems(file);
        Item[] items;
        items = order.getItemsBundles();
        write.writeOutput(items);
    }
}
