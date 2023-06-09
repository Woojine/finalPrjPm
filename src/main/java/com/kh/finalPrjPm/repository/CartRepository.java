package com.kh.finalPrjPm.repository;

import com.kh.finalPrjPm.entity.Cart;
import com.kh.finalPrjPm.entity.Item;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface CartRepository extends JpaRepository<Cart, Long> {
}
