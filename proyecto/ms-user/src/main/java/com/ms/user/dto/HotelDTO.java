package com.ms.user.dto;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private UUID id;

    private String name;

    private  String location;

    private String information;
}
