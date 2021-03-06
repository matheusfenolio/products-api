package com.abinbev.productManagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProductNameUpdateParameterDto {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is required")
    private String productName;

    public ProductNameUpdateParameterDto() {
    }

    public ProductNameUpdateParameterDto(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductNameUpdateParameterDto)) return false;
        ProductNameUpdateParameterDto that = (ProductNameUpdateParameterDto) o;
        return getProductName().equals(that.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName());
    }
}
