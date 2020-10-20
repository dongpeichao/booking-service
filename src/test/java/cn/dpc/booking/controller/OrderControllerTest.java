package cn.dpc.booking.controller;

import cn.dpc.booking.domain.BookingOrder;
import cn.dpc.booking.domain.OrderStatus;
import cn.dpc.booking.domain.OrderType;
import cn.dpc.booking.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @MockBean
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_create_order_status_to_prove_when_price_more_than_1000() throws Exception {
        BookingOrder bookingOrder = BookingOrder.builder()
                .type(OrderType.PLANE)
                .content("H111")
                .price(100100)
                .status(OrderStatus.TO_APPROVE)
                .build();
        Mockito.when(orderService.createOrder(any())).thenReturn(bookingOrder);

        mockMvc.perform(post("/user/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\": \"PLANE\", \"content\": \"H111\", \"price\": 100100}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("TO_APPROVE"));
    }

}
