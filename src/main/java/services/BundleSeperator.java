package services;

import java.util.*;

public class BundleSeperator {

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
}
