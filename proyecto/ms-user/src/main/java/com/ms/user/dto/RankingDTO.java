package com.ms.user.dto;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {

    private String id;

    private String UserId;

    private String hotelId;

    private int starts;

    private String observation;

    private HotelDTO hotel;
}
