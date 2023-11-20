package com.fruttare.app.resources;

import com.fruttare.app.dto.ClientDTO;
import com.fruttare.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping (value = "/{id}")
    public ResponseEntity <ClientDTO> findById(@PathVariable Long id){
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<ClientDTO> insert(@ModelAttribute ClientDTO dto) {
    dto = service.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.ok().body(dto);
}


}
