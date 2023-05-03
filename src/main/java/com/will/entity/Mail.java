package com.will.entity;

import java.util.List;
import java.util.Objects;

public class Mail {

    private List<UserMessage> userList;
    private List<IngredientMessage> ingredientList;

    public Mail() {
    }

    public List<UserMessage> getUserList() {
        return userList;
    }

    public void setUserList(List<UserMessage> userList) {
        this.userList = userList;
    }

    public List<IngredientMessage> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientMessage> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(userList, mail.userList) && Objects.equals(ingredientList, mail.ingredientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList, ingredientList);
    }
}
