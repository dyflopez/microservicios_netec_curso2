package com.ms.user.controller.v1;

import com.ms.user.controller.v1.docs.UserDoc;
import com.ms.user.dto.UserDTO;
import com.ms.user.dto.UserRankingDTO;
import com.ms.user.exception.MyHandleException;
import com.ms.user.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController implements UserDoc {

    private final IUserService iUserService;
    @Override
    @PostMapping
    public ResponseEntity create(UserDTO userDTO) {
        return this.iUserService.create(userDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity getAll() {
        return this.iUserService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    @CircuitBreaker(name ="responseCircuitBreaker",fallbackMethod = "responseFallback")
    public ResponseEntity getById(String id) {
         return  this.iUserService.getById(id);
    }


    public ResponseEntity responseFallback(String userId,Exception e){
      var salida =  UserRankingDTO
                .builder()
                .email("daniel0223@hotmail.es")
                .name("daniel")
                .information("Mensjae de error por que el CB esta abierto")
                .build();
        return ResponseEntity.ok(salida);
    }

}
