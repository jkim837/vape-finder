package com.jake.vapefinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jake.vapefinder.dto.StoreDTO;
import com.jake.vapefinder.service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<StoreDTO> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public StoreDTO getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    public StoreDTO createStore(@RequestBody StoreDTO storeDTO) {
        return storeService.createStore(storeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}