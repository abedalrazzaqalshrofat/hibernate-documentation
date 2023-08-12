package com.newtechage.entity;

import com.mysql.cj.jdbc.Clob;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.ListIndexJavaType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "basic_price")
    private Float basicPrice;

    @Column(name = "shipping_fees")
    private Float shippingFees;

    @Formula(value = "basic_price * shipping_fees")
    @Column(name = "total_price")
    private float totalPrice;


    @ElementCollection
    private String[] names;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Float basicPrice) {
        this.basicPrice = basicPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(Float shippingFees) {
        this.shippingFees = shippingFees;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", basicPrice=" + basicPrice +
                ", shippingFees=" + shippingFees +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
