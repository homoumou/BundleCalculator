package domain;

import lombok.Getter;
import lombok.Setter;
import services.BundleCalculator;
import services.BundleSeperator;

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

    public void seperateBundles(BundleSeperator bundleSeperator) {
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundleSeperator.setBundleCalculator(bundleCalculator);
        this.bundles = bundleSeperator.calculateBundle(postNums, formatCode);
    }


    public double getTotoalPrice() {
        double totoalPrice = 0;
        for (int j = 0; j < bundles.size(); j++) {
            Bundle bundle = bundles.get(j);
            totoalPrice += bundle.getBundlePrice();
        }
        return totoalPrice;
    }
}




