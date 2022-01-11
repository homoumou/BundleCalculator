import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    //    Input: 10 IMG
    public void test10Img(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(10, "IMG");
        assertEquals(800, totoalPrice,"wrong price");
    }

    @Test
    // Input: 15 FLAC
    public void test15Flac(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(15, "FLAC");
        assertEquals(1957.5, totoalPrice,"wrong price");
    }

    @Test
    //Input: 13 VID
    public void test13Vid(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(13, "VID");
        assertEquals(2370, totoalPrice,"wrong price");
    }

    @Test
    //Input: 17 VID
    public void test17Vid(){
        // 17 9 5 3
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(17, "VID");
        assertEquals(3000, totoalPrice,"wrong price");
    }

    @Test
    //Input: 23 VID
    public void test23Vid(){
        // 23 9 9 5
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(23, "VID");
        assertEquals(3960, totoalPrice,"wrong price");
    }

    @Test
    public void test12Img(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(12, "IMG");
        assertEquals(1250, totoalPrice,"wrong price");
    }


    @Test
    public void test14Flac(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(14, "FLAC");
        assertEquals(1957.5, totoalPrice,"wrong price");
    }

    @Test
    public void test12Vid(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(12, "VID");
        assertEquals(2100, totoalPrice,"wrong price");
    }


}
