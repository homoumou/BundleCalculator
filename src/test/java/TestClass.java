import domain.Item;
import org.junit.jupiter.api.Test;
import services.BundleSeperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    //    Input: 10 IMG
    public void test10Img() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(10);
        item.setFormatCode("IMG");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(800, totoalPrice, "wrong price");
    }

    @Test
    // Input: 15 FLAC
    public void test15Flac() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(15);
        item.setFormatCode("FLAC");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 13 VID
    public void test13Vid() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(13);
        item.setFormatCode("VID");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(2370, totoalPrice, "wrong price");
    }

    @Test
    //Input: 17 VID
    public void test17Vid() {
        // 17 9 5 3
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(17);
        item.setFormatCode("VID");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(3000, totoalPrice, "wrong price");
    }

    @Test
    //Input: 23 VID
    public void test23Vid() {
        // 23 9 9 5
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(23);
        item.setFormatCode("VID");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(3960, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 IMG
    public void test12Img() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(12);
        item.setFormatCode("IMG");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1250, totoalPrice, "wrong price");
    }


    @Test
    //Input: 14 Flac
    public void test14Flac() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(14);
        item.setFormatCode("FLAC");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 Vid
    public void test12Vid() {
        BundleSeperator bundleSeperator = new BundleSeperator();
        Item item = new Item();
        item.setPostNums(12);
        item.setFormatCode("VID");
        item.seperateBundles(bundleSeperator);
        double totoalPrice = item.getTotoalPrice();
        assertEquals(2100, totoalPrice, "wrong price");
    }


}
