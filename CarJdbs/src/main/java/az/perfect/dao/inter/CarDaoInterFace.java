/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Car;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface CarDaoInterFace {

    void update(Car c);

    void insert(Car c);

    void delete(int id);

    Car getCar(int id);

    List<Car> getAllCar();

}
