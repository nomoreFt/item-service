package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();



    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("item1", 1000, 10);
         Item save = itemRepository.save(item);

        assertThat(item).isEqualTo(save);
    }

    @Test
    void findById() {
        Item item = new Item("item1", 1000, 10);
        Item save = itemRepository.save(item);

        itemRepository.findById(save.getId());
        assertThat(save).isEqualTo(item);

    }

    @Test
    void findAll() {
        Item item1 = new Item("item1", 1000, 10);
        Item item2 = new Item("item2", 2000, 10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> all = itemRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(item1, item2);
    }

    @Test
    void update() {
        Item item1 = new Item("item1", 1000, 10);
        Item save = itemRepository.save(item1);

        Item updateParam = new Item("item2", 2000, 20);
        itemRepository.update(save.getId(), updateParam);

        Item findItem = itemRepository.findById(save.getId());

        assertThat(findItem).isEqualTo(findItem);
    }

    @Test
    void clearStore() {
    }
}