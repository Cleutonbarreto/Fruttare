package com.fruttare.app.resources;

import com.fruttare.app.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {

//    private ClientService service;

@RequestMapping("/")
public ModelAndView index(){
   return new ModelAndView("index");
    }

    @GetMapping
    public ResponseEntity <List<ClientDTO>> findAll(){
        List<ClientDTO> list = new ArrayList<>();
        list.add(new ClientDTO(35L, "Joseph", "15342563250", 4500.0, Instant.parse("1996-12-16T08:25:00Z"),2  ));
        return ResponseEntity.ok().body(list);
    }

}
