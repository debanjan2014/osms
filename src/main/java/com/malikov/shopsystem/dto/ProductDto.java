package com.malikov.shopsystem.dto;

import com.malikov.shopsystem.model.ProductCategory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ProductDto implements Serializable {

    private Long productId;

    private Long productVariationId;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private Boolean unlimited;

    private Set<ProductCategory> categories;

    public ProductDto(
            Long productId,
            Long productVariationId,
            String name,
            BigDecimal price,
            Integer quantity,
            Boolean unlimited,
            Set<ProductCategory> categories
    ) {
        this.productId = productId;
        this.productVariationId = productVariationId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unlimited = unlimited;
        this.categories = categories;
    }

    public ProductDto() {
    }

    public Long getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isNew() {
        return productVariationId == null;
    }

    public Boolean getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(Boolean unlimited) {
        this.unlimited = unlimited;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productVariationId=" + productVariationId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", unlimited=" + unlimited +
                '}';
    }

}
