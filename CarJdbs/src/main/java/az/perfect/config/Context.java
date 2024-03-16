/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.config;

import az.perfect.dao.impl.CarDaoImpl;
import az.perfect.dao.impl.CategoryDaoImpl;
import az.perfect.dao.impl.CountryDaoImpl;
import az.perfect.dao.inter.CarDaoInterFace;
import az.perfect.dao.inter.CategoryDaoInterFace;
import az.perfect.dao.inter.CountryDaoInterFace;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Context {

    public static CarDaoInterFace instanceCar() {
        return new CarDaoImpl();
    }

    public static CountryDaoInterFace instanceCountry() {
        return new CountryDaoImpl();
    }

    public static CategoryDaoInterFace instanceCategory() {
        return new CategoryDaoImpl();
    }

}
