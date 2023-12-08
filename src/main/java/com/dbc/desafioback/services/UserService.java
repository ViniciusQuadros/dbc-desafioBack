package com.dbc.desafioback.services;

import com.dbc.desafioback.domain.user.User;
import com.dbc.desafioback.domain.user.UserType;
import com.dbc.desafioback.dtos.UserDTO;
import com.dbc.desafioback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void validateVotingUser(User user) throws Exception {
        if(!user.getUserType().equals(UserType.ASSOCIATE)){
            throw new Exception("Usuário não é associado");
        }
        if(!validateVoter(user)){
            throw new Exception("Usuário não pode votar");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO userDTO){
        User user = new User(userDTO);
        this.saveUser(user);
        return user;
    }

    public void saveUser(User user){this.userRepository.save(user);}

    public List<User> getAllUsers(){ return this.userRepository.findAll();}

    private boolean validateVoter(User user){
        //ResponseEntity<Map> voterValidationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/57f23672-c15f-48f8-90d3-d84ce00250b8/users/".concat(user.getDocument()), Map.class);     //"status": "UNABLE_TO_VOTE"
        ResponseEntity<Map> voterValidationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/68ddd0eb-bb01-49d3-af16-7ee63ff401ea/users/".concat(user.getDocument()), Map.class);       //"status": "ABLE_TO_VOTE"

        if(voterValidationResponse.getStatusCode().equals(HttpStatus.OK)){
            String status = (String) voterValidationResponse.getBody().get("status");
            return "ABLE_TO_VOTE".equalsIgnoreCase(status);
        }else return false;
    }
}
