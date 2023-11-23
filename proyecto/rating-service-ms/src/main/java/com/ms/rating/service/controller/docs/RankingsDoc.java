package com.ms.rating.service.controller.docs;

import com.ms.rating.service.dto.RankingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Ranking Controller", description = "API exposed for CRUD operations on Ranking")
public interface RankingsDoc {

    @Operation(summary = "create Ranking",
            description = "This operation is for creating Ranking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ranking created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity create(
            @RequestBody  RankingDto userDto
    );

    @Operation(summary = "List Rankings ",
            description = "This operation is for getting all rankings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list of rankings  successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getRankings();

    @Operation(summary = "Get rankings by  userId",
            description = "This operation is for searching a ranking by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ranking information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getByUserId(@PathVariable String userId );

    @Operation(summary = "Get rankings by  hotelId",
            description = "This operation is for searching a ranking by hotelId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ranking information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getByHotelId(@PathVariable String hotelId );

}
