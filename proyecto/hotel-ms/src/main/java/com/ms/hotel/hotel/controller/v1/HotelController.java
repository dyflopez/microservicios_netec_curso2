package com.ms.hotel.hotel.controller.v1;

import com.ms.hotel.hotel.controller.v1.docs.HotelDoc;
import com.ms.hotel.hotel.dto.HotelDto;
import com.ms.hotel.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController implements HotelDoc {

    private final IHotelService iHotelService;

    @Override
    @PostMapping
    public ResponseEntity create(HotelDto hotelDto) {
        return this.iHotelService.create(hotelDto);
    }

    @Override
    @GetMapping
    public ResponseEntity getAll() {
        return this.iHotelService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity getById(UUID id) {
        return  this.iHotelService.getById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(UUID id ) {
        return  this.iHotelService.delete(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity updateById(UUID id , HotelDto hotelDto) {
        return  this.iHotelService.updateById(id,hotelDto);
    }
}
