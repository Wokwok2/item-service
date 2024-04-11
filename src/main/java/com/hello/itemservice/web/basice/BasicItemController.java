package com.hello.itemservice.web.basice;

import com.hello.itemservice.domain.item.Item;
import com.hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> all = itemRepository.findAll();
        model.addAttribute("items", all);
        return "basic/items";
    }

    /*
    * 테스트용 테이터 추가
    *
    * */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("ItemA", 10000, 10));
        itemRepository.save(new Item("ItemB", 20000, 20));
    }


}
