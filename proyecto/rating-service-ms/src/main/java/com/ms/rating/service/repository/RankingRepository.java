package com.ms.rating.service.repository;

import com.ms.rating.service.model.RankingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RankingRepository extends MongoRepository<RankingDocument,String> {

    List<RankingDocument> findByUserId(String userID);

    List<RankingDocument> findByHotelId(String hotelId);

}
