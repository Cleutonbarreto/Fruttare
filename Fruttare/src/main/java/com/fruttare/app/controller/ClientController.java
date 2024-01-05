package com.fruttare.app.controller;

import com.fruttare.app.dto.ClientDTO;
import com.fruttare.app.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/templates/static")
public class ClientController {


/*@RequestMapping("/")
public ModelAndView index(){
   return new ModelAndView("index");
    }*/

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


//    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ModelAndView insert(@ModelAttribute @Valid ClientDTO dto, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){
//            ModelAndView modelAndView = new ModelAndView("index");
//            modelAndView.addObject("mensagem", "Erro no preenchimento do formulário");
//                    return modelAndView;
//        }
//        dto = service.insert(dto);
//
//        ModelAndView modelAndView = new ModelAndView("redirect:/");
//        modelAndView.addObject("mensagem", "Cadastro salvo com sucesso!");
//
//        return modelAndView;
//    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView insert(@ModelAttribute @Valid ClientDTO dto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("mensagem", "Erro no preenchimento do formulário");
        } else {
            dto = service.insert(dto);
            modelAndView.addObject("mensagem", "Cadastro salvo com sucesso!");
            modelAndView.addObject("novoCliente", new ClientDTO());
        }

        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("novoCliente", new ClientDTO());
        return modelAndView;
    }


}
