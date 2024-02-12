package com.example.recrutmenttool.Service.impl;

import com.example.recrutmenttool.Repositories.ClientRepository;
import com.example.recrutmenttool.Service.ClientService;
import com.example.recrutmenttool.Transformers.ClientTransformer;
import com.example.recrutmenttool.dto.requestDto.ClientRequestDto;
import com.example.recrutmenttool.models.Client;
import jakarta.websocket.ClientEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public String addClient(ClientRequestDto clientRequestDto) throws Exception {

        Client client = ClientTransformer.convertEntity(clientRequestDto);


        if(client.getUsername()==null){
            throw new RuntimeException("username is not present");
        }


        clientRepository.save(client);

        return "Added succsefully";
    }
}
