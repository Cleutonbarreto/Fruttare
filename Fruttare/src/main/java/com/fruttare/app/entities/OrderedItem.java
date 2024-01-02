package com.fruttare.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity

public class OrderedItem {

    @Id
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_SalesOrder", referencedColumnName = "id")
    private SalesOrder salesOrder;

    private Double amount;

    private Double unitPrice;

    private Double discount;

    private Double totalItems;

    public OrderedItem (){
    }

    public OrderedItem(Long id, @NotNull Product product, @NotNull SalesOrder salesOrder, Double amount, Double unitPrice, Double discount, Double totalItems) {
        this.id = id;
        this.product = product;
        this.salesOrder = salesOrder;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.totalItems = totalItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Double totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedItem that = (OrderedItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
