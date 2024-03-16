/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import az.perfect.dao.inter.CategoryDaoInterFace;
import az.perfect.entity.Car;
import az.perfect.entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Behruz Tapdiqov
 */
public class CategoryDaoImpl extends AbstractDao implements CategoryDaoInterFace {

    @Override
    public void update(Category t) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("update category set category_name=? where category_id=?");
            st.setString(1, t.getCategory_name());
            st.setInt(2, t.getCategory_id());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Category t) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into category (category_name) values(?)");
            st.setString(1, t.getCategory_name());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("delete from category where category_id=?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Category getCategoryById(int id) {
        Category c = null;
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select *from category where category_id=" + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c = getCategory(rs);
            }
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;

    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new LinkedList<>();
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select *from category");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(getCategory(rs));
            }
            st.execute();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return list;

    }

    public static Category getCategory(ResultSet rs) throws SQLException {

        int category_id = rs.getInt("category_id");
        String category_name = rs.getString("category_name");
        Category c = new Category(category_id, category_name);
        return c;
    }

}
