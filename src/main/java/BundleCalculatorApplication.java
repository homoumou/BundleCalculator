import domain.Order;
import services.InputReader;
import services.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;

public class BundleCalculatorApplication {
    public static void main(String[] args) throws IOException {
        InputReader read = new InputReader();
        OutputWriter write = new OutputWriter();
        String file = "src/main/java/input.txt";
        Order order = read.readInput(file);
        write.writeOutput(order);
    }
}
