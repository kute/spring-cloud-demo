package com.kute.springcloudopenfeign.feigh;

import com.kute.springcloudopenfeign.entity.Comment;
import com.kute.springcloudopenfeign.feigh.config.MyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by bailong001 on 2020/02/02 16:20
 * <p>
 * 不使用全局配置，使用自定义 MyFeignConfig
 */
@FeignClient(name = "storeService", configuration = MyFeignConfig.class,
        fallback = StoreService.StoreServiceFallback.class)
public interface StoreService {

    /**
     * @return
     */
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    String getName();

    /**
     * @param comment
     * 定制 QueryMap
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    void addComment(@SpringQueryMap Comment comment);


    @Component
    class StoreServiceFallback implements StoreService {

        @Override
        public String getName() {
            return "StoreServiceFallback";
        }

        @Override
        public void addComment(Comment comment) {

        }
    }

}
