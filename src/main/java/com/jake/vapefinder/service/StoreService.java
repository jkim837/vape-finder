package com.jake.vapefinder.service;

import com.jake.vapefinder.model.Store;
import com.jake.vapefinder.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}