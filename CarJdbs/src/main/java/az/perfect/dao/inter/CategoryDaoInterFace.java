/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.perfect.dao.inter;

import az.perfect.entity.Car;
import az.perfect.entity.Category;
import az.perfect.entity.Country;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public interface CategoryDaoInterFace {

    void update(Category t);

    void insert(Category t);

    void delete(int id);

    Category getCategoryById(int id);

    List<Category> getAllCategory();

}
