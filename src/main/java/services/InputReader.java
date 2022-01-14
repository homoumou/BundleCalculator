package services;

import domain.Item;
import domain.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public Order readInput(String fileSrc){
        final String file = fileSrc;
        Order order = new Order();
        BundleCalculator bundleCalculator = new BundleCalculator();
        BundleSeperator bundleSeperator = new BundleSeperator();
        List<String> firstColList = new ArrayList<>();
        List<String> secondColList = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            String content = null;

            while((content = bf.readLine()) != null){
                String array[] = content.trim().split("\\s+");
                firstColList.add(array[0]);
                secondColList.add(array[1]);
            }

            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] firstColAry = firstColList.toArray(new String[0]);
        String[] secondColAry = secondColList.toArray(new String[0]);
        Item[] items = new Item[firstColAry.length];
        for(int i = 0; i < firstColAry.length; i++){
            items[i] = new Item();
            items[i].setPostNums(Integer.parseInt(firstColAry[i]));
            items[i].setFormatCode(secondColAry[i]);
        }
        order.setItems(items);
//        order.getItemsBundles(bundleCalculator);
        order.getItemsBundles(bundleSeperator);
        return order;
    }
}
