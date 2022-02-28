package com.example;

import java.util.Objects;

public class Operator {
    int option;
    String value;

    public Operator() {
    }

    public Operator(int option, String value) {
        this.option = option;
        this.value = value;
    }

    public int getOption() {
        return this.option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operator option(int option) {
        setOption(option);
        return this;
    }

    public Operator value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Operator)) {
            return false;
        }
        Operator operator = (Operator) o;
        return option == operator.option && Objects.equals(value, operator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(option, value);
    }

    @Override
    public String toString() {
        return "{" +
            " option='" + getOption() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
}
