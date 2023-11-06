package com.fruttare.app.resources;

import com.fruttare.app.dto.ClientDTO;
import com.fruttare.app.entities.Client;
import com.fruttare.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {


@RequestMapping("/")
public ModelAndView index(){
   return new ModelAndView("index");
    }

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity <List<ClientDTO>> findAll(){
        List<ClientDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
