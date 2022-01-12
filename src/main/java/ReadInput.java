import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {

    public Item[] readInput(String fileSrc){
        final String file = fileSrc;

        List<String> firstColList = new ArrayList<String>();
        List<String> secondColList = new ArrayList<String>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            String content = null;

            while((content = bf.readLine()) != null){
                String ary[] = content.trim().split("\\s+");

                firstColList.add(ary[0]);
                secondColList.add(ary[1]);
            }

            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] firstColAry = firstColList.toArray(new String[0]);
        String[] secondColAry = secondColList.toArray(new String[0]);
        Item[] items = new Item[firstColAry.length];
        for(int i = 0; i < firstColAry.length; i++){
            items[i] = new Item();
            items[i].setPostNums(Integer.parseInt(firstColAry[i]));
            items[i].setFormatCode(secondColAry[i]);
        }
        return items;
    }
//    public static void main(String[] args) {
//        final String file = "src/main/java/input.txt";
//
//        List<String> firstColList = new ArrayList<String>();
//        List<String> secondColList = new ArrayList<String>();
//
//        try {
//            BufferedReader bf = new BufferedReader(new FileReader(file));
//
//            String content = null;
//
//            while((content = bf.readLine()) != null){
//                String ary[] = content.trim().split("\\s+");
//
//                firstColList.add(ary[0]);
//                secondColList.add(ary[1]);
//            }
//
//            bf.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String[] firstColAry = firstColList.toArray(new String[0]);
//        String[] secondColAry = secondColList.toArray(new String[0]);
//        System.out.println("The item in the array is: ");
//        Item[] items = new Item[firstColAry.length];
//        for(int i = 0; i < firstColAry.length; i++){
//            System.out.println(firstColAry[i] + "\t" + secondColAry[i]);
//            items[i] = new Item();
//            items[i].setPostNums(Integer.parseInt(firstColAry[i]));
//            items[i].setFormatCode(secondColAry[i]);
//        }
//
//    }
}
