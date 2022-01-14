package domain;

import lombok.Getter;
import lombok.Setter;
import services.BundleCalculator;

import java.util.ArrayList;


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

    public ArrayList<Bundle> calculateBundles(BundleCalculator bundleCalculator) {
        this.bundles = bundleCalculator.calculateBundle(postNums, formatCode);
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




