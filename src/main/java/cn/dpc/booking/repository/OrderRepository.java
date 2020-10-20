package cn.dpc.booking.repository;

import cn.dpc.booking.domain.BookingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<BookingOrder, String> {
}
