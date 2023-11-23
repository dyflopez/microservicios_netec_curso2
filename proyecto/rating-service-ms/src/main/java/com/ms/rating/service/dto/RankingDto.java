package com.ms.rating.service.dto;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {


    private String userId;

    private String hotelId;

    private int starts;

    private String observation;

}
