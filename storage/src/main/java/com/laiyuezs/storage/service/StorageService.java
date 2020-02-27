package com.laiyuezs.storage.service;

import com.laiyuezs.storage.dao.StorageRepository;
import com.laiyuezs.storage.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 */
@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Transactional
    public void deduct(String commodityCode, int count) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        System.out.println("------商品id-----"+commodityCode+"-------库存------"+storage.getCount());
        storage.setCount(storage.getCount() - count);
        System.out.println("----Storage-----"+storage);
        storageRepository.save(storage);
    }
}
