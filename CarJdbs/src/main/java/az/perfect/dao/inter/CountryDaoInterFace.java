/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Car;
import az.perfect.entity.Country;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface CountryDaoInterFace {

    void update(Country t);

    void insert(Country t);

    void delete(int id);

    Country getCountryById(int id);

    List<Country> getAllCountry();

}
