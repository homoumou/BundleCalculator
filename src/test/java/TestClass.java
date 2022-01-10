import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    @Test
    public void Test1(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(10, "IMG");
        assertEquals(800, totoalPrice,"wrong price");
    }

    @Test
    public void Test2(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(15, "FLAC");
        assertEquals(1957.5, totoalPrice,"wrong price");
    }

    @Test
    public void Test3(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(13, "VID");
        assertEquals(2370, totoalPrice,"wrong price");
    }

    @Test
    public void Test4(){
        // 17 9 5 3
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(17, "VID");
        assertEquals(3000, totoalPrice,"wrong price");
    }

    @Test
    public void Test5(){
        // 23 9 9 5
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(23, "VID");
        assertEquals(3960, totoalPrice,"wrong price");
    }

    @Test void Test6(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(12, "IMG");
        assertEquals(1250, totoalPrice,"wrong price");
    }

    @Test void Test7(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(15, "FLAC");
        assertEquals(1957.5, totoalPrice,"wrong price");
    }

    @Test void Test8(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(14, "FLAC");
        assertEquals(1957.5, totoalPrice,"wrong price");
    }

    @Test void Test9(){
        BundleCalculator bundleCalculator = new BundleCalculator();
        double totoalPrice = bundleCalculator.Calculate(12, "VID");
        assertEquals(2100, totoalPrice,"wrong price");
    }


}
