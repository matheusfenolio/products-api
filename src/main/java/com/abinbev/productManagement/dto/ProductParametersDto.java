package com.abinbev.productManagement.dto;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class ProductParametersDto {
    @NonNull
    private String name;
    private String description;
    @NonNull
    private double price;

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
