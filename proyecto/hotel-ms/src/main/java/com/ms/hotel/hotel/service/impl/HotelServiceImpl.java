package com.ms.hotel.hotel.service.impl;

import com.ms.hotel.hotel.dto.HotelDto;
import com.ms.hotel.hotel.exception.MyHandleException;
import com.ms.hotel.hotel.mapper.HotelMapper;
import com.ms.hotel.hotel.model.HotelEntity;
import com.ms.hotel.hotel.repository.HotelRepository;
import com.ms.hotel.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final HotelRepository hotelRepository;

    @Override
    public ResponseEntity create(HotelDto hotelDto) {
        HotelEntity hotelEntity = HotelMapper.getHotelDtoToHotelEntity(hotelDto);
        var hotel = hotelRepository.save(hotelEntity);
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @Override
    public ResponseEntity getAll() {
        var hotels = this.hotelRepository.findAll();
        return  ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @Override
    public ResponseEntity getById(UUID id) {
        var hotel = this.hotelRepository.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @Override
    public ResponseEntity delete(UUID id) {
        var hotel = this
                .hotelRepository
                .findById(id)
                .orElseThrow(() -> new MyHandleException("The client does not exist"));
        this.hotelRepository.delete(hotel);
        return  ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity updateById(UUID id , HotelDto hotelDto) {
        var hotel = this
                .hotelRepository
                .findById(id)
                .orElseThrow(() -> new MyHandleException("The client does not exist"));
        hotel = HotelMapper.getHotelEntityMapperHotelDto(hotel,hotelDto);

        this.hotelRepository.save(hotel);
        return ResponseEntity.ok(hotel);
    }

}
