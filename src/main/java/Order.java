import lombok.Data;

@Data
public class Order {
    Item[] items;

    void setItems(String fileSrc){
        ReadInput read = new ReadInput();
        this.items = read.readInput(fileSrc);
    }

    void calculate (){
        for(int i=0; i<items.length; i++){
            items[i].getTotoalPrice();
        }
    }
}
