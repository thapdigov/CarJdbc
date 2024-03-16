/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.entity;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Car {

    private int car_id;
    private String car_name;
    private String car_marka;
    private String car_year;
    private int car_price;
    private Country country;
    private Category category;

    public Car() {
    }

    public Car(int car_id) {
        this.car_id = car_id;
    }

    public Car(int car_id, String car_name, String car_marka, String car_year, int car_price, Country country, Category category) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_marka = car_marka;
        this.car_year = car_year;
        this.car_price = car_price;
        this.country = country;
        this.category = category;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_marka() {
        return car_marka;
    }

    public void setCar_marka(String car_marka) {
        this.car_marka = car_marka;
    }

    public String getCar_year() {
        return car_year;
    }

    public void setCar_year(String car_year) {
        this.car_year = car_year;
    }

    public int getCar_price() {
        return car_price;
    }

    public void setCar_price(int car_price) {
        this.car_price = car_price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "\nCar:" + "\n" + "\ncar_id=" + car_id + "\ncar_name=" + car_name
                + "\ncar_marka=" + car_marka + "\ncar_year=" + car_year + "\ncar_price=" + car_price
                + "\ncountry=" + country + "\ncategory=" + category + "\n";
    }

}
