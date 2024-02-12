package com.example.recrutmenttool.Controllers;


import com.example.recrutmenttool.Service.ClientService;
import com.example.recrutmenttool.dto.requestDto.ClientRequestDto;
import com.example.recrutmenttool.models.Client;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("add")

    public ResponseEntity addClient(@RequestBody ClientRequestDto clientRequestDto) throws Exception{
        try{
            return new ResponseEntity(clientService.addClient(clientRequestDto), HttpStatus.ACCEPTED);
        }
        catch (Exception e ){
            return new ResponseEntity( e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
