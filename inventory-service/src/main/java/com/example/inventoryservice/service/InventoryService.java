package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepo;

//    public Boolean isInStock(String skuCode){
//        Inventory inventory =  inventoryRepository.findBySkuCode(skuCode);
//        if(inventory != null)
//            return true;
//        else
//            return false;
//    }
    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode){
        for(String sku : skuCode){
            System.out.println("skuCode = "+sku);
        }
        List<Inventory> inventories =  inventoryRepo.findBySkuCodeIn(skuCode);
        System.out.println(inventories);
        return inventories.stream().map(inventory -> {
            System.out.println("skuCode = "+inventory.getQuantity());
            return InventoryResponse.builder()
                    .skuCode(inventory.getSkuCode())
                    .isInStock(inventory.getQuantity()>0 ? true : false).build();
        }).toList();
    }

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepo.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }
}
