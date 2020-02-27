package com.laiyuezs.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author liliang
 * @Date 2020/2/24 21:24
 * @Description
 **/
@FeignClient(name = "storage-service")
@Component
public interface StorageFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
