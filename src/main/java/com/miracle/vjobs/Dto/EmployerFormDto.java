package com.miracle.vjobs.Dto;

import java.util.Objects;

public class EmployerFormDto {
    private String position;
    private String companyName;
    private String ship;
    private String price;
    private String about;

    public EmployerFormDto() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployerFormDto that = (EmployerFormDto) o;
        return Objects.equals(position, that.position) && Objects.equals(companyName, that.companyName) && Objects.equals(ship, that.ship) && Objects.equals(price, that.price) && Objects.equals(about, that.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, companyName, ship, price, about);
    }
}
