package com.jake.vapefinder.controller;

import com.jake.vapefinder.model.Store;
import com.jake.vapefinder.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}