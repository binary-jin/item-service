package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("춘식", 100, 1);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("말하는 춘식", 100, 10);
        Item item2 = new Item("맥주먹는 춘식", 200, 5);
        Item item3 = new Item("조재혁", 1, 1);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        //when
        List<Item> findItem = itemRepository.findAll();

        //then
        Assertions.assertThat(findItem.size()).isEqualTo(3);
        Assertions.assertThat(findItem).contains(item1, item2, item3);

    }

    @Test
    void updateItem() {
        //give
        Item item1 = new Item("말하는 춘식", 100, 10);
        Item saved = itemRepository.save(item1);
        Long itemId = saved.getId();

        //when
        Item updateParam = new Item("item2", 200, 4);
        itemRepository.update(itemId,updateParam);

        //then
        Item findId = itemRepository.findById(itemId);
        Assertions.assertThat(findId.getItemName()).isEqualTo(updateParam.getItemName());
        Assertions.assertThat(findId.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findId.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

}