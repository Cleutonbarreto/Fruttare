package com.fruttare.app.dto;

import com.fruttare.app.entities.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private static final long serialVersionID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String phone;
    private String cep;
    private String city;
    private String state;

    public ClientDTO(){
    }

    public ClientDTO(Long id, String name, String cpf, String address, String phone, String cep, String city, String state) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.cep = cep;
        this.city = city;
        this.state = state;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.cep = entity.getCep();
        this.city = entity.getCity();
        this.state = entity.getState();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter e Setter para o campo 'state'
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
