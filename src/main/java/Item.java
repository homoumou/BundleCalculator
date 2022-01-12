import lombok.*;

import java.util.Map;

@Data
public class Item {
    private int postNums;
    private String formatCode;
    private Map bundleTable;

    public Item(){
        this.postNums = 0;
        this.formatCode = null;
    }

    public Item(int postNums, String formatCode) {
        this.postNums = postNums;
        this.formatCode = formatCode;
    }

    public Map getBundleTable() {
        // create bundles table
        Bundles bundles = new Bundles(formatCode);
        // get Bundle Table
        Map bundleTable = bundles.getBundleTable();
        return bundleTable;
    }

    public double getTotoalPrice() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        return bundleCalculator.getTotoalPrice(postNums, formatCode);
    }

}
