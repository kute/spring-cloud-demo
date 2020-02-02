package com.kute.springcloudopenfeign.feigh;

import com.kute.springcloudopenfeign.entity.Comment;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

/**
 * created by kute on 2020/02/02 16:24
 * name、url 支持  ${...} 表达式
 */
@FeignClient(name = "${kute.feign.app.name}", fallbackFactory = AppService.AppServiceFallbackFactory.class)
public interface AppService {

    /**
     * @param type
     * @return
     */
    @RequestMapping(value = "/getCommentList/{type}", method = RequestMethod.GET)
    List<Comment> getCommentList(@PathVariable String type);

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/getComment/{id}", method = RequestMethod.GET)
    Comment getComment(@PathVariable String id);

    /**
     * 将 comment对象的属性字段作为 get请求的参数
     *
     * @param comment
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    void addComment(@SpringQueryMap Comment comment);

    /**
     * fallback
     */
    @Component
    class AppServiceFallbackFactory implements FallbackFactory<AppService> {

        @Override
        public AppService create(Throwable throwable) {
            return new AppService() {
                @Override
                public List<Comment> getCommentList(String type) {
                    return Collections.emptyList();
                }

                @Override
                public Comment getComment(String id) {
                    return new Comment().setId("-1").setName("fallBackName");
                }

                @Override
                public void addComment(Comment comment) {

                }
            };
        }
    }

}
