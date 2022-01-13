import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Order {
    Item[] items;

    void setItems(String fileSrc){
        ReadInput read = new ReadInput();
        this.items = read.readInput(fileSrc);
    }

    double calculate() {
        double totoalPrice = 0;
        for (int i = 0; i < items.length; i++) {
            totoalPrice = 0;
            ArrayList bundles = items[i].getBundles();
            for (int j = 0; j < bundles.size(); j++) {
                Bundle bundle = (Bundle) bundles.get(j);

                totoalPrice += bundle.getBundlePrice();
            }
        }
        return totoalPrice;
    }
    Item[] getItemsBundles(){
        for(int i=0; i<items.length; i++){
            ArrayList<Bundle> bundles = new ArrayList();
            items[i].setBundles(bundles);
            items[i].calculateBundles();
        }
        return items;
    }

}
