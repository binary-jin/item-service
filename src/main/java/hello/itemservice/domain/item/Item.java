package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //핵심 도메인 모델을 쓸 때 안 쓰는 게 좋음 getter, setter만 쓰고 필요한 걸 따로 쓰는 게 조음
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //가격이 안 들어갈 수도 있는 상황 가정
    private Integer quantity; //null의 상황도 가정 -> int 대신 Integer

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
