import java.util.*;

import org.apache.log4j.Logger;

public class BundleCalculator {

    public double getTotoalPrice(int postNums, String formatCode) {
        // initial
        int bundleNum;
        int remind = postNums;
        double price;
        double totoalPrice = 0;
        final Logger savePriceLog = Logger.getLogger("savePriceLog");

        // create bundles table
        Bundles bundles = new Bundles(formatCode);
        // get Bundle Table
        Map bundleTable = bundles.getBundleTable();
        // get the keyArray
        int[] keyArray = getKeySet(bundleTable);
        // get the bundleKeySet
        Set<Integer> bundleKeySet = getBundleKeySet(keyArray, postNums);

        Iterator ite = bundleKeySet.iterator();
        //  the element in set is unrepeatable, then {5,5,3} => {5,3}
        while (ite.hasNext()) {
            int key = (int) ite.next();
            if (((remind / key) > 0)) {
                bundleNum = remind / key;
                remind = remind - bundleNum * key;
                price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(key)));
                savePriceLog.info(bundleNum + " * " + key + " $" + price);
                System.out.println(bundleNum + " * " + key + " $" + price);
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
                    System.out.println(bundleNum + " * " + key + " $" + price);
                    savePriceLog.info(bundleNum + " * " + key + " $" + price);
                    totoalPrice += price;
                }
            }
            if (!ite.hasNext() && (remind % key) != 0) {
                price = Double.parseDouble(String.valueOf(bundleTable.get(key)));
                System.out.println(1 + " * " + key + " $" + price);
                savePriceLog.info(1 + " * " + key + " $" + price);
                totoalPrice += price;
            }
        }
        savePriceLog.info(postNums + " " + formatCode + " $" + totoalPrice);
        System.out.println(postNums + " " + formatCode + " $" + totoalPrice);

        return totoalPrice;
    }

    private int[] getKeySet(Map bundleTable) {
        Set keySet = bundleTable.keySet();
        Set<Integer> reverseSets = new TreeSet<>(Comparator.reverseOrder());
        Iterator ite = keySet.iterator();
        // sort the key set (decrease)
        while (ite.hasNext()) {
            reverseSets.add((Integer) ite.next());
        }
        int[] keyArray = new int[keySet.size()];
        Iterator sortedIte = reverseSets.iterator();
        for (int index = 0; sortedIte.hasNext(); index++) {
            keyArray[index] = (Integer) sortedIte.next();
        }
        return keyArray;
    }

    private Set<Integer> getBundleKeySet(int[] keyArray, int postNums) {
        Set<Integer> reverseSets = new TreeSet<>(Comparator.reverseOrder());
        for (int key : keyArray) {
            reverseSets.add(key);
        }
        labe:
        for (int j = 0; j < keyArray.length; j++) {
            int first_remind = postNums - keyArray[j];
            for (int i = 0; i < keyArray.length; i++) {
                if (first_remind % keyArray[i] == 0) {
                    reverseSets.clear();
                    reverseSets.add(keyArray[j]);
                    reverseSets.add(keyArray[i]);
                    break labe;
                } else {
                    int second_remind = first_remind - keyArray[i];
                    for (int k = 0; k < keyArray.length; k++) {
                        if (second_remind > 0 && second_remind % keyArray[k] == 0) {
                            reverseSets.clear();
                            reverseSets.add(keyArray[j]);
                            reverseSets.add(keyArray[i]);
                            reverseSets.add(keyArray[k]);
                            break labe;
                        }
                    }
                }
            }
        }
        return reverseSets;
    }
}
