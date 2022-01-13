import lombok.*;

import java.util.ArrayList;
import java.util.Map;


@Getter
@Setter
public class Item {
    private int postNums;
    private String formatCode;
    private ArrayList<Bundle> bundles;

    public Item() {
        this.postNums = 0;
        this.formatCode = null;
    }

    public Item(int postNums, String formatCode) {
        this.postNums = postNums;
        this.formatCode = formatCode;
    }

    public Map<Integer, Double> getBundleTable() {
        // create bundles table
        Bundle bundle = new Bundle();
        // get Bundle Table
        Map bundleTable = bundle.getBundleTable(formatCode);
        return bundleTable;
    }

    public ArrayList<Bundle> calculateBundles() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundles = bundleCalculator.getBundle(postNums, formatCode);
        return bundles;
    }

    public double getTotoalPrice() {
        double totoalPrice = 0;
        for (int j = 0; j < bundles.size(); j++) {
            Bundle bundle = (Bundle) bundles.get(j);
            totoalPrice += bundle.getBundlePrice();
        }
        return totoalPrice;
    }
}




