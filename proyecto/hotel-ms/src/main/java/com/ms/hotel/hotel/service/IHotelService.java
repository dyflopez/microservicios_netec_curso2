package com.ms.hotel.hotel.service;

import com.ms.hotel.hotel.dto.HotelDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IHotelService {

    ResponseEntity create(HotelDto hotelDto);

    ResponseEntity getAll();

    ResponseEntity getById(UUID id);

    ResponseEntity delete(UUID id );

    ResponseEntity updateById(UUID id , HotelDto hotelDto);
}
