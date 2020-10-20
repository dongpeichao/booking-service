package cn.dpc.booking.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BookingOrder {
    @Id
    @GeneratedValue
    private Long id;

    private OrderType type;

    private OrderStatus status;

    private Integer price;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public BookingOrder(OrderType type, OrderStatus status, String content,Integer price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.type = type;
        this.status = status;
        this.content = content;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
