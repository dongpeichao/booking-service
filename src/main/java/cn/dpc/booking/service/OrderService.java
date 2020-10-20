package cn.dpc.booking.service;

import cn.dpc.booking.domain.BookingOrder;
import cn.dpc.booking.domain.OrderStatus;
import cn.dpc.booking.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public BookingOrder createOrder(BookingOrder order) {
        if(order.getPrice() > 1000*100) {
            order.setStatus(OrderStatus.TO_APPROVE);
        }

        orderRepository.save(order);

        return order;
    }
}
