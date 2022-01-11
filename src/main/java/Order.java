import lombok.*;

import java.util.Map;

@Data
public class Order {
    private int postNums;
    private String formatCode;
    private Map bundleTable;

    public Map getBundleTable() {
        // create bundles table
        Bundles bundles = new Bundles(formatCode);
        // get Bundle Table
        Map bundleTable = bundles.getBundleTable();
        return bundleTable;
    }

    public double calculate() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        return bundleCalculator.calculate(postNums, formatCode);
    }

}
