package com.ms.rating.service.serv;

import com.ms.rating.service.dto.RankingDto;
import org.springframework.http.ResponseEntity;

public interface IRankingService {

    ResponseEntity create(RankingDto rankingDto);

    ResponseEntity getAll();

    ResponseEntity getByUserId(String userID);

    ResponseEntity getByHotelId(String hotelId);
}
