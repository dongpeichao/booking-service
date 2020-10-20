package cn.dpc.booking.controller;

import cn.dpc.booking.controller.dto.BookingOrderRequest;
import cn.dpc.booking.domain.BookingOrder;
import cn.dpc.booking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/user/{userId}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingOrder createOrder(@PathVariable("userId") String userId,
                                    @RequestBody BookingOrderRequest request) {
        return orderService.createOrder(request.getBookingOrder());
    }
}
