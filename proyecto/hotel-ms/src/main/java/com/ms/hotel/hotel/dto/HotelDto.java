package com.ms.hotel.hotel.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String location;

    @NotBlank
    @NotEmpty
    private String information;
}
