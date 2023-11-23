package com.ms.hotel.hotel.mapper;

import com.ms.hotel.hotel.dto.HotelDto;
import com.ms.hotel.hotel.model.HotelEntity;

public class HotelMapper {

    public static HotelEntity getHotelDtoToHotelEntity(HotelDto hotelDto){
        return HotelEntity
                .builder()
                .information(hotelDto.getInformation())
                .location(hotelDto.getLocation())
                .name(hotelDto.getName())
                .build();
    }

    public static HotelEntity getHotelEntityMapperHotelDto(HotelEntity hotelEntity, HotelDto hotelDto){

        hotelEntity.setInformation(hotelDto.getInformation());
        hotelEntity.setLocation(hotelDto.getLocation());
        hotelEntity.setName(hotelDto.getName());

        return hotelEntity;
    }

}
