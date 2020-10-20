package cn.dpc.booking.controller.dto;

import cn.dpc.booking.domain.BookingOrder;
import cn.dpc.booking.domain.OrderType;
import lombok.Data;

@Data
public class BookingOrderRequest {
    private OrderType type;
    private Integer price;
    private String content;

    public BookingOrder getBookingOrder() {
        return BookingOrder.builder()
                .type(type)
                .price(price)
                .content(content)
                .build();
    }
}
