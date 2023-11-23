package com.ms.rating.service.controller;

import com.ms.rating.service.controller.docs.RankingsDoc;
import com.ms.rating.service.dto.RankingDto;
import com.ms.rating.service.serv.IRankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rankings")
public class RankingController implements RankingsDoc {


    private final IRankingService iRankingService;

    public RankingController(IRankingService iRankingService) {
        this.iRankingService = iRankingService;
    }

    @PostMapping
    public ResponseEntity create( RankingDto rankingDto){
        return this.iRankingService.create(rankingDto);
    }

    @GetMapping
    public ResponseEntity getRankings(){
        return this.iRankingService.getAll();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getByUserId(String userId){
        return this.iRankingService.getByUserId(userId);
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity getByHotelId( String hotelId){
        return this.iRankingService.getByHotelId(hotelId);
    }

}
