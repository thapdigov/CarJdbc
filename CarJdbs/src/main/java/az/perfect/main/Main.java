/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package az.perfect.main;

import az.perfect.config.Context;
import az.perfect.dao.impl.CarDaoImpl;
import az.perfect.entity.Car;
import az.perfect.entity.Category;
import az.perfect.entity.Country;

/**
 *
 * @author Behruz Tapdiqov
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(Context.instanceCountry().getCountryById(1));
       
       

    }
}
