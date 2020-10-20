package cn.dpc.booking.service;


import cn.dpc.booking.domain.BookingOrder;
import cn.dpc.booking.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static cn.dpc.booking.domain.OrderStatus.TO_APPROVE;
import static cn.dpc.booking.domain.OrderType.PLANE;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;

    @Test
    public void should_create_order_status_to_prove_when_price_more_than_1000() {
        BookingOrder order = BookingOrder.builder()
                .price(1001*100)
                .type(PLANE)
                .build();

        BookingOrder result = orderService.createOrder(order);
        assertEquals(TO_APPROVE, result.getStatus());
    }
}
