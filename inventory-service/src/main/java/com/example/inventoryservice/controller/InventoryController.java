package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


//    @GetMapping("/{sku-code}")
//    @ResponseStatus(HttpStatus.OK)
//    public Boolean isInStock(@PathVariable("sku-code") String skuCode){
//        System.out.println(skuCode);
//        return inventoryService.isInStock(skuCode);
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        System.out.println("Inside InventoryController");
        return inventoryService.isInStock(skuCode,quantity);
    }
}
