package com.ms.user.conf;

import com.ms.user.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-HOTEL")
public interface HotelServiceFeing {

    @GetMapping("/hotel/{hotelId}")
    HotelDTO getHotel(@PathVariable String hotelId);
}
