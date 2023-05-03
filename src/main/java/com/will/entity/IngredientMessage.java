package com.will.entity;

import java.util.Objects;

public class IngredientMessage {

    private String name;
    private Double quantityInKg;

    public IngredientMessage() {
    }

    public IngredientMessage(String name, Double quantityInKg) {
        this.name = name;
        this.quantityInKg = quantityInKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantityInKg() {
        return quantityInKg;
    }

    public void setQuantityInKg(Double quantityInKg) {
        this.quantityInKg = quantityInKg;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", quantityInKg=" + quantityInKg + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientMessage that = (IngredientMessage) o;
        return Objects.equals(name, that.name) && Objects.equals(quantityInKg, that.quantityInKg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantityInKg);
    }
}
