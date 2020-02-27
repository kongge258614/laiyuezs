package com.laiyuezs.business.service;

import com.laiyuezs.business.feign.OrderFeignClient;
import com.laiyuezs.business.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liliang
 * @Date 2020/2/24 21:21
 * @Description
 **/
@Service
public class BusinessService {

    @Autowired
    private StorageFeignClient storageFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;


    /**
     * 减库存，下订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount){
        // 减库存
        storageFeignClient.deduct(commodityCode,orderCount);

        // 创建订单
        orderFeignClient.create(userId,commodityCode,orderCount);

    }
}
