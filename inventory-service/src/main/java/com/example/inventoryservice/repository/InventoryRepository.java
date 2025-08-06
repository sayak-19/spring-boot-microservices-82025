package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT x from Inventory x where x.skuCode = :skucode")
    Inventory findBySkuCode(@Param("skucode") String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);  // Hibernate: select i1_0.id,i1_0.quantity,i1_0.sku_code from t_inventory i1_0 where i1_0.sku_code in(?)

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);
}
