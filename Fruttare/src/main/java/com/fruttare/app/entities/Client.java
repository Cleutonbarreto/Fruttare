package com.fruttare.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @NotBlank(message = "Telefone é obrigatório")
    private String phone;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Cidade é obrigatória")
    private String city;

    @NotBlank(message = "Estado é obrigatório")
    private String state;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant registrationDate;

    public Client() {
        this.registrationDate = Instant.now();
    }

    public Client(Long id, String name, String cpf, String address, String phone, String cep) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.cep = cep;
        this.registrationDate = Instant.now();
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

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getcep() {
        return cep;
    }

    public void setcep(String cep) {
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

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
