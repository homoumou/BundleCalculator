import domain.Item;
import org.junit.jupiter.api.Test;
import services.BundleCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    //    Input: 10 IMG
    public void test10Img() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(10);
        item.setFormatCode("IMG");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(800, totoalPrice, "wrong price");
    }

    @Test
    // Input: 15 FLAC
    public void test15Flac() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(15);
        item.setFormatCode("FLAC");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 13 VID
    public void test13Vid() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(13);
        item.setFormatCode("VID");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(2370, totoalPrice, "wrong price");
    }

    @Test
    //Input: 17 VID
    public void test17Vid() {
        // 17 9 5 3
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(17);
        item.setFormatCode("VID");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(3000, totoalPrice, "wrong price");
    }

    @Test
    //Input: 23 VID
    public void test23Vid() {
        // 23 9 9 5
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(23);
        item.setFormatCode("VID");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(3960, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 IMG
    public void test12Img() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(12);
        item.setFormatCode("IMG");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1250, totoalPrice, "wrong price");
    }


    @Test
    //Input: 14 Flac
    public void test14Flac() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(14);
        item.setFormatCode("FLAC");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 Vid
    public void test12Vid() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Item item = new Item();
        item.setPostNums(12);
        item.setFormatCode("VID");
        item.setBundles(item.calculateBundles(bundleCalculator));
        double totoalPrice = item.getTotoalPrice();
        assertEquals(2100, totoalPrice, "wrong price");
    }


}
