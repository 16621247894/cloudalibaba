package zwq.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zwq.domain.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 根据id减少库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count);

}
