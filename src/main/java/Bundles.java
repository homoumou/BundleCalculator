import java.util.HashMap;
import java.util.Map;

import lombok.*;

@Getter
@Setter
public class Bundles {

    private Map bundleTable;


    public Bundles(String formatCode) {
        switch (formatCode) {
            case "IMG":
                Map imgTable = new HashMap();
                imgTable.put(10, 800);
                imgTable.put(5, 450);
                this.bundleTable = imgTable;
                break;
            case "FLAC":
                Map audioTable = new HashMap();
                audioTable.put(3, 427.50);
                audioTable.put(6, 810);
                audioTable.put(9, 1147.50);
                this.bundleTable = audioTable;
                break;
            case "VID":
                Map videoTable = new HashMap();
                videoTable.put(3, 570);
                videoTable.put(5, 900);
                videoTable.put(9, 1530);
                this.bundleTable = videoTable;
                break;
        }
    }

}
