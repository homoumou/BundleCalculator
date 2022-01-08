import java.util.*;

public class BundleCalculator {


    public double Calculate(int nums, String formatCode ){
        // initial
        int bundleNum;
        int remind = nums;
        double price;
        double totoalPrice = 0;

        // create bundles table
        Map imgTable = new HashMap();
        imgTable.put(10,800);
        imgTable.put(5,450);

        Map audioTable = new HashMap();
        audioTable.put(3,427.50);
        audioTable.put(6,810);
        audioTable.put(9,1147.50);

        Map videoTable = new HashMap();
        videoTable.put(3,570);
        videoTable.put(5,900);
        videoTable.put(9,1530);

        Map bundleTable = new HashMap();

        // select table
        switch (formatCode){
            case "IMG":
                bundleTable  = imgTable;
                break;
            case "FLAC":
                bundleTable = audioTable;
                break;
            case "VID":
                bundleTable = videoTable;
                break;
        }



        // get the key set
        Set keySet = bundleTable.keySet();
        Set<Integer> reverseSets = new TreeSet<>(Comparator.reverseOrder());
        Iterator  ite = keySet.iterator();

        // sort the key set
        while(ite.hasNext()){
            reverseSets.add((Integer) ite.next());
        }
        int[] keyArray = new int[keySet.size()];

        Iterator sortedIte = reverseSets.iterator();
       for (int index = 0; sortedIte.hasNext();index++){
           keyArray[index] = (Integer) sortedIte.next();
       }

       // 17 - 9 = 8 (first_remind)   8 - 5 = 3 (secong_remind)   3-3 = 0
       // [9 , 5, 3]
        //  13 - 9 = 4 (first_remind)
        //  13 - 5 = 8
        //  13 - 3 = 10
        labe:for(int j= 0; j < keyArray.length;j++){
            int first_remind = nums-keyArray[j];
            for(int i= 0; i < keyArray.length; i++) {
                if (first_remind % keyArray[i] == 0) {
                    reverseSets.clear();
                    reverseSets.add(keyArray[j]);
                    reverseSets.add(keyArray[i]);
                    break labe;
                } else {
                    int second_remind = first_remind - keyArray[i];
                    for (int k = 0; k < keyArray.length; k++){
                       if(second_remind > 0 && second_remind % keyArray[k] == 0){
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

        //  the element in set is unrepeatable, then {5,5,3} => {5,3}
        ite = reverseSets.iterator();
        while(ite.hasNext()){
            int key = (int)ite.next();
            if(((remind / key) > 0)){
                bundleNum = remind / key;
                remind = remind - bundleNum * key;
                price = bundleNum * Double.parseDouble(String.valueOf(bundleTable.get(key)));
                System.out.println(bundleNum + " * " + key + " $"+price);
                totoalPrice += price;
            }

            if(remind < key){
//                // finding closest bundles
//                int min_key = 0;
//                int min_remind = 99;
//                while(ite.hasNext()) {
//                    int temp_key = (int)ite.next();
//                    if (min_remind > (temp_key - remind) && min_remind > 0){
//                        min_key = temp_key;
//                        min_remind = temp_key - remind;
//                    }
//                }
                price = Double.parseDouble(String.valueOf(bundleTable.get(key)));
                System.out.println(1 + " * " + key + " $"+price);
                totoalPrice += price;
            }
        }
       System.out.println(nums +" "+ formatCode + " $" +totoalPrice);
       return totoalPrice;
    }

    public static void main(String[] args) {
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundleCalculator.Calculate(14, "FLAC");
    }
}
