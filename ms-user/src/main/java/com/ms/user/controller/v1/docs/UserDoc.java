package com.ms.user.controller.v1.docs;


import com.ms.user.dto.UserDTO;
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

@Tag(name = "user controller netec",description = "API Exposed for CRUD operations on user")
public interface UserDoc {


    @Operation(summary =  "create user",
    description =  "This operation is for creating a user")
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "201",
                    description = "user created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity create( @Valid @RequestBody UserDTO userDTO);

    @Operation(summary =  "listar",
            description =  "lista todos los usuarios")
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200",
                            description = "user created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity findAll();


    @Operation(summary =  "buscar por id",
            description =  "obtener usuario por id")
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200",
                            description = "user created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity findById(@PathVariable String id);


}
