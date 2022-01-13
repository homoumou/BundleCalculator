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
        for (int i = 0; i < items.length; i++) {
            double totoalPrice = 0;
            ArrayList bundles = items[i].getBundles();
            System.out.println(items[i].getPostNums() + " " + items[i].getFormatCode() + " " + items[i].getTotoalPrice());
            for (int j = 0; j < bundles.size(); j++) {
                Bundle bundle = (Bundle) bundles.get(j);
               System.out.println(bundle.getBundleNum() + " * " + bundle.getKey() + " $" + bundle.getBundlePrice());
                totoalPrice += bundle.getBundlePrice();
            }

        }
        write.writeOutput(items);
    }
}
