package services;

import domain.Bundle;
import lombok.Data;
import org.apache.log4j.Logger;

import java.util.*;

@Data
public class BundleSeperator {

    BundleCalculator bundleCalculator = new BundleCalculator();

    public int[] getKeyArray(Map bundleTable) {
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

    public Set<Integer> getBundleKeySet(int[] keyArray, int postNums) {
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

    public ArrayList<Bundle> covertBundlesMap(ArrayList<Map> bundlesMap){
        Bundle bundle = new Bundle();
        ArrayList<Bundle> bundles = new  ArrayList<>();
        for (int i=0;i<bundlesMap.size();i++){
            bundle = new Bundle();
            Map bundleMap = bundlesMap.get(i);
            bundle.setBundleNum((Integer) bundleMap.get("bundleNum"));
            bundle.setKey((Integer) bundleMap.get("key"));
            bundle.setBundlePrice((Double) bundleMap.get("bundlePrice"));
            bundles.add(bundle);
        }
        return bundles;
    }

    public ArrayList<Bundle> calculateBundle(int postNums, String formatCode) {
        // initial
        int bundleNum;
        double price;
        double totoalPrice = 0;
        final Logger savePriceLog = Logger.getLogger("savePriceLog");
        // create bundles list
        ArrayList<Bundle> bundles = new  ArrayList<>();
        ArrayList<Map> bundlesMap = new ArrayList<>();

        Map bundleMap = new HashMap();
        Bundle bundle = new Bundle();
        // get Bundle Table
        Map bundleTable = bundle.getBundleTable(formatCode);
        // get the keyArray
        int[] keyArray = getKeyArray(bundleTable);
        // get the bundleKeySet
        Set<Integer> bundleKeySet = getBundleKeySet(keyArray, postNums);
        Iterator ite = bundleKeySet.iterator();
        bundlesMap = bundleCalculator.calculate(postNums, bundleKeySet, bundleTable);

        //covert bundlesMap into bundles
        bundles = covertBundlesMap(bundlesMap);


        return bundles;
    }

}
