package com.jake.vapefinder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jake.vapefinder.dto.StoreDTO;
import com.jake.vapefinder.mapper.StoreMapper;
import com.jake.vapefinder.model.Store;
import com.jake.vapefinder.repository.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreMapper storeMapper;

    public List<StoreDTO> getAllStores() {
        return storeRepository.findAll()
                .stream()
                .map(storeMapper::toDto)
                .collect(Collectors.toList());
    }

    public StoreDTO getStoreById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        return storeMapper.toDto(store);
    }

    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = storeMapper.toEntity(storeDTO);
        return storeMapper.toDto(storeRepository.save(store));
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}