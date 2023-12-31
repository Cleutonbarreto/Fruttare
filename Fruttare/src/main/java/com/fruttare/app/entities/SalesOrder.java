package com.fruttare.app.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tb_sales_order")
public class SalesOrder implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant orderDate;



    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateOfIssue;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant deliveryDate;

    private Double totalOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.RASCUNHO;

    public SalesOrder() {
        this.orderDate = Instant.now();
    }

    public SalesOrder(Long id, Client client, Instant dateOfIssue, Instant deliveryDate, Double totalOrder, OrderStatus status) {
        this.id = id;
        this.client = client;
        this.dateOfIssue = dateOfIssue;
        this.deliveryDate = deliveryDate;
        this.totalOrder = totalOrder;
        this.status = status;
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

    public Double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder that = (SalesOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
