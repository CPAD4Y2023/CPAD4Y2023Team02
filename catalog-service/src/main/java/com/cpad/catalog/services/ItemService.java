package com.cpad.catalog.services;

import com.cpad.catalog.dtos.request.CreateItemRequest;
import com.cpad.catalog.dtos.request.UpdateItemRequest;
import com.cpad.catalog.entities.Item;
import com.cpad.catalog.exceptions.child.ItemAlreadyExistsException;
import com.cpad.catalog.exceptions.parent.BadRequestException;
import com.cpad.catalog.repositories.ItemRepository;
import com.cpad.catalog.utils.Constants;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class ItemService {

  private ItemRepository itemRepository;

  public void validateItemsRequest(Set<CreateItemRequest> items) throws BadRequestException {
    if (CollectionUtils.isEmpty(items)) return;

    for (CreateItemRequest item : items) {

      item.setName(item.getName().trim());

      if (!StringUtils.hasText(item.getName()))
        throw new BadRequestException(Constants.ITEM_NAME_CAN_NOT_BE_EMPTY_EXCEPTION.getName());

      if (itemRepository.findByNameIgnoreCase(item.getName()).isPresent())
        throw new ItemAlreadyExistsException(
            String.format(Constants.ITEM_ALREADY_EXISTS_EXCEPTION.getName(), item.getName()));
    }
  }

  public Item getItemFromItemRequest(CreateItemRequest itemRequest) {
    return Item.builder().name(itemRequest.getName()).build();
  }

  public void deleteItemById(String id) {
    itemRepository.deleteById(id);
  }

  public void validateItemsNames(List<UpdateItemRequest> itemRequests)
      throws ItemAlreadyExistsException {
    for (UpdateItemRequest itemRequest : itemRequests) {

      itemRequest.setName(itemRequest.getName().trim());

      boolean itemNameExists;
      if (itemRequest.getId() != null)
        itemNameExists =
            itemRepository.existsByNameIgnoreCaseAndIdNotIn(
                itemRequest.getName(), List.of(itemRequest.getId()));
      else itemNameExists = itemRepository.existsByNameIgnoreCase(itemRequest.getName());

      if (itemNameExists)
        throw new ItemAlreadyExistsException(
            String.format(
                Constants.ITEM_ALREADY_EXISTS_EXCEPTION.getName(), itemRequest.getName()));
    }
  }
}
