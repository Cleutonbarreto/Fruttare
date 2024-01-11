package com.fruttare.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tb_sales_order")
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    @NotNull
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant orderDate;


    @NotNull
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateOfIssue;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant deliveryDate;

    @NotNull
    private BigDecimal totalOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.FECHADO;

    public SalesOrder() {
        this.orderDate = Instant.now();
    }


    public SalesOrder(Long id, Client client, Instant dateOfIssue, Instant deliveryDate, BigDecimal totalOrder, OrderStatus status) {
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

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
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
