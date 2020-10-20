package cn.dpc.booking.feign;

import cn.dpc.booking.BookingServiceApplication;
import cn.dpc.booking.feign.dto.PlaneOrderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookingServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableStubRunnerServer
public class PlaneClientTest {
    @Autowired
    private PlaneClient planeClient;

    @Test
    public void should_create_plane_order_success() {
        PlaneOrderRequest request = PlaneOrderRequest.builder()
                .content("H111")
                .price(100100)
                .build();
        planeClient.createOrder(request);
    }
}
