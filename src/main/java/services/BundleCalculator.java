package services;

import domain.Bundle;
import domain.Item;
import org.apache.log4j.Logger;

import java.util.*;

public class BundleCalculator {

    public ArrayList<Map> calculate(int remind, Set<Integer> bundleKeySet, Map bundleTable){
        int bundleNum;
        double price;
        Iterator ite = bundleKeySet.iterator();
        ArrayList<Map> bundlesMap = new ArrayList<>();
        Map bundleMap = new HashMap();

        while (ite.hasNext()) {
            int key = (int) ite.next();
            if (((remind / key) > 0)) {
                bundleNum = remind / key;
                remind = remind - bundleNum * key;
                price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(key)));
                bundleMap = new HashMap();
                bundleMap.put("bundleNum",bundleNum);
                bundleMap.put("key",key);
                bundleMap.put("bundlePrice",price);
                bundlesMap.add(bundleMap);
            } else {
                // if reminding post can`t make as bundles, find the closet bundles as compensation
                if (remind > 0) {
                    Iterator minIte = bundleKeySet.iterator();
                    int minKey = 0;
                    double minMargin = 9999;
                    while (minIte.hasNext()) {
                        // 14 - 9 = 5  5-6 = -1
                        int tempKey = (int) minIte.next();
                        double tempMargin = remind - tempKey;
                        if (Math.abs(minMargin) > Math.abs(tempMargin) && tempMargin < 0) {
                            minKey = tempKey;
                            minMargin = tempMargin;
                        }
                    }
                    bundleNum = 1;
                    remind = 0;
                    price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(minKey)));
                    bundleMap = new HashMap();
                    bundleMap.put("bundleNum",bundleNum);
                    bundleMap.put("key",key);
                    bundleMap.put("bundlePrice",price);
                    bundlesMap.add(bundleMap);
                }
            }
            if (!ite.hasNext() && (remind % key) != 0) {
                price = Double.parseDouble(String.valueOf(bundleTable.get(key)));
                bundleMap = new HashMap();
                bundleMap.put("bundleNum",1);
                bundleMap.put("key",key);
                bundleMap.put("bundlePrice",price);
                bundlesMap.add(bundleMap);
            }
        }


        return bundlesMap;
    }
}
