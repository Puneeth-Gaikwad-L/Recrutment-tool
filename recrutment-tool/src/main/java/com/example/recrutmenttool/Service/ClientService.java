package com.example.recrutmenttool.Service;

import com.example.recrutmenttool.dto.requestDto.ClientRequestDto;

public interface ClientService {

    String addClient(ClientRequestDto clientRequestDto) throws Exception;
}
