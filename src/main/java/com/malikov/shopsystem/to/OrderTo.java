package com.malikov.shopsystem.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.malikov.shopsystem.model.OrderStatus;
import com.malikov.shopsystem.model.PaymentType;
import com.malikov.shopsystem.util.serializers.LocalDateDeserializer;
import com.malikov.shopsystem.util.serializers.LocalDateSerializer;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderTo {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone")
    private String phoneNumber;

    @JsonProperty("city")
    private String city;

    @JsonProperty("nova_poshta")
    private String novaPoshta;

    @JsonProperty("total_sum")
    private Integer totalSum;

    @JsonProperty("payment_type")
    private PaymentType paymentType;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty("date")
    private LocalDate datePlaced;

    private Timestamp timestamp;

    @JsonProperty("status")
    private OrderStatus status;

    private List<OrderItemTo> products;

    @JsonCreator
    public OrderTo(
            @JsonProperty("id")Integer id
            , @JsonProperty("first_name")String firstName
            , @JsonProperty("last_name")String lastName
            , @JsonProperty("phone")String phoneNumber
            , @JsonProperty("city")String city
            , @JsonProperty("nova_poshta")String novaPoshta
            , @JsonProperty("total_sum")String totalSum
            , @JsonProperty("payment_type")PaymentType paymentType
            , @JsonProperty("date") LocalDate datePlaced
            , @JsonProperty("timestamp")Timestamp timestamp
            , @JsonProperty("status") OrderStatus status
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.novaPoshta = novaPoshta;
        this.paymentType = paymentType;
        this.datePlaced = datePlaced;
        this.status = status;
        products = new ArrayList<>();
        this.totalSum = 0;
    }

    public OrderTo(
            Integer id
            ,String firstName
            ,String lastName
            ,String phoneNumber
            ,String city
            ,String novaPoshta
            ,PaymentType paymentType
            ,LocalDate datePlaced
            ,OrderStatus status
            ,List<OrderItemTo> products
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.novaPoshta = novaPoshta;
        this.paymentType = paymentType;
        this.datePlaced = datePlaced;
        this.status = status;
        this.totalSum = products.stream().mapToInt(p -> (p.getPrice() * p.getQuantity())).sum();
        this.products = products;
    }

    public OrderTo(
            Integer id
            ,String firstName
            ,String lastName
            ,String phoneNumber
            ,String city
            ,String novaPoshta
            ,PaymentType paymentType
            ,LocalDate datePlaced
            ,OrderStatus status
    ) {
        this(id, firstName, lastName, phoneNumber, city, novaPoshta, paymentType, datePlaced, status, new ArrayList<>());
        this.totalSum = 0;
    }

    public OrderTo() {
    }

    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    public void addProduct(OrderItemTo orderItemTo) {
        products.add(orderItemTo);
        this.totalSum += orderItemTo.getPrice();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("phone")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("nova_poshta")
    public String getNovaPoshta() {
        return novaPoshta;
    }

    @JsonProperty("total_sum")
    public Integer getTotalSum() {
        return totalSum;
    }

    @JsonProperty("total_sum")
    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    @JsonProperty("payment_type")
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    public LocalDate getDatePlaced() {
        return datePlaced;
    }

    @JsonProperty("timestamp")
    public Timestamp getTimestamp() {
        return Timestamp.valueOf(datePlaced.atStartOfDay());
    }

    @JsonProperty("status")
    public OrderStatus getStatus() {
        return status;
    }

    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public void setDatePlaced(LocalDate datePlaced) {

        this.datePlaced = datePlaced;
    }
    @JsonProperty("nova_poshta")
    public void setNovaPoshta(String novaPoshta) {
        this.novaPoshta = novaPoshta;
    }

    @JsonProperty("payment_type")
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("status")
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItemTo> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItemTo> products) {
        this.products = products;
    }

}