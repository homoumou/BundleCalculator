import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    //    Input: 10 IMG
    public void test10Img() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(10);
        order.setFormatCode("IMG");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(800, totoalPrice, "wrong price");
    }

    @Test
    // Input: 15 FLAC
    public void test15Flac() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(15);
        order.setFormatCode("FLAC");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 13 VID
    public void test13Vid() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(13);
        order.setFormatCode("VID");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(2370, totoalPrice, "wrong price");
    }

    @Test
    //Input: 17 VID
    public void test17Vid() {
        // 17 9 5 3
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(17);
        order.setFormatCode("VID");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(3000, totoalPrice, "wrong price");
    }

    @Test
    //Input: 23 VID
    public void test23Vid() {
        // 23 9 9 5
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(23);
        order.setFormatCode("VID");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(3960, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 IMG
    public void test12Img() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(12);
        order.setFormatCode("IMG");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(1250, totoalPrice, "wrong price");
    }


    @Test
    //Input: 14 Flac
    public void test14Flac() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(14);
        order.setFormatCode("FLAC");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(1957.5, totoalPrice, "wrong price");
    }

    @Test
    //Input: 12 Vid
    public void test12Vid() {
        BundleCalculator bundleCalculator = new BundleCalculator();
        Order order = new Order();
        order.setPostNums(12);
        order.setFormatCode("VID");
        double totoalPrice = order.getTotoalPrice();
        assertEquals(2100, totoalPrice, "wrong price");
    }


}
