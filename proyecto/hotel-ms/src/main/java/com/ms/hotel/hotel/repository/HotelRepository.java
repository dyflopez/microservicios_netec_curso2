package com.ms.hotel.hotel.repository;

import com.ms.hotel.hotel.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository  extends JpaRepository<HotelEntity, UUID> {
}
