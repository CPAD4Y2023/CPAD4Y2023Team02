package com.cpad.catalog.services;

import com.cpad.catalog.dtos.common.CreateItemDTO;
import com.cpad.catalog.entities.Item;
import com.cpad.catalog.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public boolean validateItemsRequest(Set<CreateItemDTO> items) {
        if (CollectionUtils.isEmpty(items))
            return false;

        for (CreateItemDTO item : items) {

            item.setName(item.getName().trim());

            if (itemRepository.findByNameIgnoreCase(item.getName()).isPresent()) {
                return false;
            }
        }

        return true;
    }

    public Item getItemFromItemRequest(CreateItemDTO itemRequest) {
        return Item.builder()
                .name(itemRequest.getName())
                .build();
    }
}
