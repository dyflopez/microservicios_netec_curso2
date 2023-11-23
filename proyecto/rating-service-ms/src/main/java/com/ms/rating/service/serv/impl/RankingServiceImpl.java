package com.ms.rating.service.serv.impl;

import com.ms.rating.service.dto.RankingDto;
import com.ms.rating.service.model.RankingDocument;
import com.ms.rating.service.repository.RankingRepository;
import com.ms.rating.service.serv.IRankingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankingServiceImpl implements IRankingService {

    private  final RankingRepository rankingRepository;


    @Override
    public ResponseEntity create(RankingDto rankingDto) {

        RankingDocument rankingDocument = new RankingDocument();
        rankingDocument.setHotelId(rankingDto.getHotelId());
        rankingDocument.setUserId(rankingDto.getUserId());
        rankingDocument.setObservation(rankingDto.getObservation());
        rankingDocument.setStarts(rankingDto.getStarts());

        var ranking = this.rankingRepository.save(rankingDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(ranking);
    }

    @Override
    public ResponseEntity getAll() {

        var ranking = this.rankingRepository.findAll();
        return ResponseEntity.ok(ranking);
    }

    @Override
    public ResponseEntity getByUserId(String userID) {
        var ranking = this.rankingRepository.findByUserId(userID);
        return ResponseEntity.ok(ranking);
    }

    @Override
    public ResponseEntity getByHotelId(String hotelId) {
        var ranking = this.rankingRepository.findByHotelId(hotelId);
        return ResponseEntity.ok(ranking);
    }


}
