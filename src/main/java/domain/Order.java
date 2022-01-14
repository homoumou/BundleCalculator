package domain;

import lombok.Getter;
import lombok.Setter;
import services.BundleCalculator;

import java.util.ArrayList;

@Getter
@Setter
public class Order {
    Item[] items;

    public Item[] getItemsBundles(BundleCalculator bundleCalculator){
        for(int i=0; i<items.length; i++){
            ArrayList<Bundle> bundles = new ArrayList();
            items[i].setBundles(bundles);
            items[i].calculateBundles(bundleCalculator);
        }
        return items;
    }

}
