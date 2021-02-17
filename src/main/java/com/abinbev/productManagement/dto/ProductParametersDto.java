package com.abinbev.productManagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProductParametersDto {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @NotNull(message = "Price cannot be null")
    private Double price;

    public ProductParametersDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductParametersDto)) return false;
        ProductParametersDto that = (ProductParametersDto) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 && getName().equals(that.getName()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice());
    }
}
