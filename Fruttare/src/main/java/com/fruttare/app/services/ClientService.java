package com.fruttare.app.services;

import com.fruttare.app.dto.ClientDTO;
import com.fruttare.app.entities.Client;
import com.fruttare.app.repositories.ClientRepository;
import com.fruttare.app.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public void saveClient(ClientDTO clientDTO) {
        Client entity = new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCpf(),
                clientDTO.getAddress(),
                clientDTO.getPhone(),
                clientDTO.getCep(),
                clientDTO.getCity(),
                clientDTO.getState()
        );
    repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional <Client> obj = repository.findById(id);
        Client entity = obj.orElseThrow(()-> new ResourceNotFoundException("Client not Found"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(@Valid ClientDTO dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setCep(dto.getCep());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
}
