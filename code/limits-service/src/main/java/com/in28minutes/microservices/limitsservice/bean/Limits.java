package com.in28minutes.microservices.limitsservice.bean;

public class Limits {

    private int minimum;
    private int maximum;

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return this.minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "{" +
                " minimum='" + getMinimum() + "'" +
                ", maximum='" + getMaximum() + "'" +
                "}";
    }

}
