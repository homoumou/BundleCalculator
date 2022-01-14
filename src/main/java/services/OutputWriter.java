package services;

import domain.Bundle;
import domain.Item;
import domain.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {

    public void writeOutput(Order order) throws IOException {
        File file = new File("src/main/java/Output.txt");
        // 创建文件
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        //write data into txt file
        Item[] items = order.getItems();
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
