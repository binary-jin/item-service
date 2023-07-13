package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    //static 사용, 아이템 Id가 Long이라 Map의 key 부분이 Long
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence); //id 값 sequence로 증가시키고 item에 저장
        store.put(item.getId(), item);  //put으로 item에 넣어줌
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear(); //저장소를 다 날리는 건데 테스트에 쓸라고 만듬
    }

}
