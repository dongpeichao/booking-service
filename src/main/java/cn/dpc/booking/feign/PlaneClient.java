package cn.dpc.booking.feign;

import cn.dpc.booking.feign.dto.PlaneOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "plane", url ="${plane.url}")
public interface PlaneClient {
    @PostMapping("/orders")
    void createOrder(@RequestBody PlaneOrderRequest request);
}
