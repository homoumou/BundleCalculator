package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Bundle {
    private int key;
    private int bundleNum;
    private double bundlePrice;

    public Map getBundleTable(String formatCode) {
        switch (formatCode) {
            case "IMG":
                Map imgTable = new HashMap();
                imgTable.put(10, 800);
                imgTable.put(5, 450);
                return  imgTable;
            case "FLAC":
                Map audioTable = new HashMap();
                audioTable.put(3, 427.50);
                audioTable.put(6, 810);
                audioTable.put(9, 1147.50);
                return audioTable;
            case "VID":
                Map videoTable = new HashMap();
                videoTable.put(3, 570);
                videoTable.put(5, 900);
                videoTable.put(9, 1530);
                return videoTable;
        }
        return null;
    }
}
