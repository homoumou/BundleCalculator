package services;

import domain.Bundle;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BundleCalculator {

    public ArrayList<Bundle> calculateBundle(int postNums, String formatCode) {
        // initial
        int bundleNum;
        int remind = postNums;
        double price;
        double totoalPrice = 0;
        final Logger savePriceLog = Logger.getLogger("savePriceLog");
        BundleSeperator seperator = new BundleSeperator();

        // create bundles table

        ArrayList<Bundle> bundles = new  ArrayList<Bundle>();
        Bundle bundle = new Bundle();
        // get Bundle Table
        Map bundleTable = bundle.getBundleTable(formatCode);
        // get the keyArray
        int[] keyArray = seperator.getKeyArray(bundleTable);
        // get the bundleKeySet
        Set<Integer> bundleKeySet = seperator.getBundleKeySet(keyArray, postNums);

        Iterator ite = bundleKeySet.iterator();
        //  the element in set is unrepeatable, then {5,5,3} => {5,3}
        while (ite.hasNext()) {
            int key = (int) ite.next();
            if (((remind / key) > 0)) {
                bundleNum = remind / key;
                remind = remind - bundleNum * key;
                price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(key)));
                savePriceLog.info(bundleNum + " * " + key + " $" + price);
                bundle = new Bundle();
                bundle.setBundleNum(bundleNum);
                bundle.setKey(key);
                bundle.setBundlePrice(price);
                bundles.add(bundle);
                totoalPrice += price;
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
                    savePriceLog.info(bundleNum + " * " + key + " $" + price);
                    bundle = new Bundle();
                    bundle.setBundleNum(bundleNum);
                    bundle.setKey(key);
                    bundle.setBundlePrice(price);
                    bundles.add(bundle);
                    totoalPrice += price;
                }
            }
            if (!ite.hasNext() && (remind % key) != 0) {
                price = Double.parseDouble(String.valueOf(bundleTable.get(key)));
                savePriceLog.info(1 + " * " + key + " $" + price);
                bundle = new Bundle();
                bundle.setBundleNum(1);
                bundle.setKey(key);
                bundle.setBundlePrice(price);
                bundles.add(bundle);
                totoalPrice += price;
            }
        }
        savePriceLog.info(postNums + " " + formatCode + " $" + totoalPrice);


        return bundles;
    }

    public ArrayList<Bundle> calculate(int postNums, String formatCode) {
        // initial
        int bundleNum;
        int remind = postNums;
        double price;
        double totoalPrice = 0;
        final Logger savePriceLog = Logger.getLogger("savePriceLog");
        BundleSeperator seperator = new BundleSeperator();

        // create bundles table

        ArrayList<Bundle> bundles = new  ArrayList<Bundle>();
        Bundle bundle = new Bundle();
        // get Bundle Table
        Map bundleTable = bundle.getBundleTable(formatCode);
        // get the keyArray
        int[] keyArray = seperator.getKeyArray(bundleTable);
        // get the bundleKeySet
        Set<Integer> bundleKeySet = seperator.getBundleKeySet(keyArray, postNums);

        Iterator ite = bundleKeySet.iterator();
        //  the element in set is unrepeatable, then {5,5,3} => {5,3}
        while (ite.hasNext()) {
            int key = (int) ite.next();
            if (((remind / key) > 0)) {
                bundleNum = remind / key;
                remind = remind - bundleNum * key;
                price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(key)));
                savePriceLog.info(bundleNum + " * " + key + " $" + price);
                bundle = new Bundle();
                bundle.setBundleNum(bundleNum);
                bundle.setKey(key);
                bundle.setBundlePrice(price);
                bundles.add(bundle);
                totoalPrice += price;
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
                    savePriceLog.info(bundleNum + " * " + key + " $" + price);
                    bundle = new Bundle();
                    bundle.setBundleNum(bundleNum);
                    bundle.setKey(key);
                    bundle.setBundlePrice(price);
                    bundles.add(bundle);
                    totoalPrice += price;
                }
            }
            if (!ite.hasNext() && (remind % key) != 0) {
                price = Double.parseDouble(String.valueOf(bundleTable.get(key)));
                savePriceLog.info(1 + " * " + key + " $" + price);
                bundle = new Bundle();
                bundle.setBundleNum(1);
                bundle.setKey(key);
                bundle.setBundlePrice(price);
                bundles.add(bundle);
                totoalPrice += price;
            }
        }
        savePriceLog.info(postNums + " " + formatCode + " $" + totoalPrice);


        return bundles;
    }
}
