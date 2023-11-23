package com.ms.rating.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("rankings")
public class RankingDocument {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private int starts;

    private String observation;


}
