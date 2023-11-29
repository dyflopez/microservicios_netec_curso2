package com.ms.user.service.impl;


import com.ms.user.conf.HotelServiceFeing;
import com.ms.user.conf.RestTemplateConfig;
import com.ms.user.dto.*;
import com.ms.user.exception.MyHandleException;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserEntity;
import com.ms.user.producer.IEmailProducer;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServiceImpl implements IUserService {

    private final RestTemplate restTemplate;

    private  final IEmailProducer iEmailProducer;


    private  final UserRepository userRepository;

    private final HotelServiceFeing hotelServiceFeing;
    @Override
    public ResponseEntity create(UserDTO userDTO) {

        String uuid = UUID.randomUUID().toString();

        UserEntity newUser = UserMapper.getUserDtoToUserEntity(userDTO);
        newUser.setId(uuid);
        var user = this.userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @Override
    public ResponseEntity getAll() {
        var user=  this.userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity getById(String id) {
        var user=  this
                .userRepository
                .findById(id).orElseThrow(()-> new MyHandleException("User does not exist"));

        var resultInformation = this.getInformationWithOpenFeingAndRestTemplate(user);


        var mensaje=  JmsEmailDetails
                .builder()
                .name(user.getName())
                .emailType("welcome")
                .recipient(user.getEmail())
                .build();
        iEmailProducer.GenerateTransactionEmail(mensaje);
        return ResponseEntity.ok(resultInformation);
    }


    private  UserRankingDTO getInformationWithOpenFeingAndRestTemplate(UserEntity user){
        UserRankingDTO userRankingDTO =new UserRankingDTO();

        userRankingDTO.setName(user.getName());
        userRankingDTO.setEmail(user.getEmail());
        userRankingDTO.setInformation(user.getInformation());
        userRankingDTO.setDocument(user.getDocument());

        RankingDTO[] rankingsVe= this.restTemplate.getForObject("http://MS-RANKING/rankings/user/"+user.getId(),RankingDTO[].class);

        var rankings = Arrays.stream(rankingsVe).collect(Collectors.toList());

        rankings
                .stream()
                .map(rankin->{
                    var hotel   = this.hotelServiceFeing.getHotel(rankin.getHotelId());
                    rankin.setHotel(hotel);
                    return rankin;
                    }
                ).collect(Collectors.toList());

        userRankingDTO.setRanking(rankings);


        return userRankingDTO;
    }

    private UserRankingDTO getWithRestTemplate(UserEntity user){
        UserRankingDTO userRankingDTO =new UserRankingDTO();

        userRankingDTO.setName(user.getName());
        userRankingDTO.setEmail(user.getEmail());
        userRankingDTO.setInformation(user.getInformation());
        userRankingDTO.setDocument(user.getDocument());

/*
        List<RankingDTO>  rankingDTOS = this
                .restTemplate
                .getForObject("http://localhost:8083/rankings/user/"+user.getId(), ArrayList.class);
*/

        RankingDTO[] rankingsVe= this.restTemplate.getForObject("http://MS-RANKING/rankings/user/"+user.getId(),RankingDTO[].class);

        var rankings = Arrays.stream(rankingsVe).collect(Collectors.toList());


        rankings.stream().map(rankin->{

                    ResponseEntity<HotelDTO> hotelReposnse  = this
                            .restTemplate
                            .getForEntity("http://MS-HOTEL/hotel/"+rankin.getHotelId(),HotelDTO.class);

                    var hotel    = hotelReposnse.getBody();

                    rankin.setHotel(hotel);
                    return rankin;
                }
        ).collect(Collectors.toList());

        userRankingDTO.setRanking(rankings);
        return userRankingDTO;

    }


}
