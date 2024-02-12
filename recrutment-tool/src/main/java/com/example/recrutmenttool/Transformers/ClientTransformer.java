package com.example.recrutmenttool.Transformers;

import com.example.recrutmenttool.dto.requestDto.ClientRequestDto;
import com.example.recrutmenttool.models.Client;

public class ClientTransformer {

    public static Client convertEntity(ClientRequestDto clientRequestDto){

        Client client = Client.builder()
                .username(clientRequestDto.getUsername())
                .email(clientRequestDto.getEmail())
                .password(clientRequestDto.getPassword())
                .organization(clientRequestDto.getOrganization())
                .build();

        return client;
    }
}
