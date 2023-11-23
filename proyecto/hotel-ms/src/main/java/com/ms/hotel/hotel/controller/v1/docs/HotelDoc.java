package com.ms.hotel.hotel.controller.v1.docs;

import com.ms.hotel.hotel.dto.HotelDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Hotel Controller", description = "API exposed for CRUD operations on Hotels")
public interface HotelDoc {
    @Operation(summary = "create hotel",
            description = "This operation is for creating hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity create(
            @RequestBody @Valid HotelDto hotelDto
            );

    @Operation(summary = "List hotels ",
            description = "This operation is for getting all hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list of hotel  generated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getAll();

    @Operation(summary = "Get hotel by  Id",
            description = "This operation is for searching a hotel by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "hotel information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getById(@PathVariable UUID id );

    @Operation(summary = "Delete hotel by account Id",
            description = "This operation is for deleting a hotel by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "hotel deleted",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity delete(@PathVariable UUID id );

    @Operation(summary = "Update hotel information",
            description = "This operation is for updating hotel information by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity updateById(@PathVariable UUID id  , @RequestBody @Valid HotelDto hotelDto);
}
