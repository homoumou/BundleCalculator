import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteOutput {
    public static void main(String[] args) throws IOException {

    }

    public void writeOutput(Item[] items) throws IOException {
        File file = new File("src/main/java/Output.txt");
        // 创建文件
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        //write data into txt file
        for (int i = 0; i < items.length; i++) {
            ArrayList bundles = items[i].getBundles();
            writer.write(items[i].getPostNums() + " " + items[i].getFormatCode() + " " + items[i].getTotoalPrice()+"\n");
            for (int j = 0; j < bundles.size(); j++) {
                Bundle bundle = (Bundle) bundles.get(j);
                writer.write("  "+bundle.getBundleNum() + " * " + bundle.getKey() + " $" + bundle.getBundlePrice()+"\n");
            }
        }
        writer.flush();
        writer.close();
    }

}
