package com.fruttare.app.dto;

import com.fruttare.app.entities.Client;
import com.fruttare.app.entities.OrderStatus;
import com.fruttare.app.entities.SalesOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


public class SalesOrderDTO implements Serializable {
    private static final long serialVersionID = 1L;

    private Long id;
    private Client client;
    private Instant orderDate;
    private Instant dateOfIssue;
    private Instant deliveryDate;
    private BigDecimal totalOrder;


    public SalesOrderDTO() {
            }

    public SalesOrderDTO(Long id, Client client, Instant dateOfIssue, Instant deliveryDate, BigDecimal totalOrder, OrderStatus status) {
        this.id = id;
        this.client = client;
        this.dateOfIssue = dateOfIssue;
        this.deliveryDate = deliveryDate;
        this.totalOrder = totalOrder;
    }

    public SalesOrderDTO (SalesOrder entity) {
        this.id = entity.getId();
        this.client = entity.getClient();
        this.dateOfIssue = entity.getDateOfIssue();
        this.deliveryDate = entity.getDeliveryDate();
        this.totalOrder = entity.getTotalOrder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Instant getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Instant dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Instant getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Instant deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }


}
