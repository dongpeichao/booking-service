package cn.dpc.booking.repository;

import cn.dpc.booking.domain.BookingOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static cn.dpc.booking.domain.OrderStatus.TO_APPROVE;
import static cn.dpc.booking.domain.OrderType.PLANE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void should_save_order_success() {
        BookingOrder order = BookingOrder.builder()
                .type(PLANE)
                .status(TO_APPROVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).build();
        BookingOrder result = orderRepository.save(order);
        assertNotNull(result.getId());
        assertEquals(PLANE, result.getType());
    }
}
