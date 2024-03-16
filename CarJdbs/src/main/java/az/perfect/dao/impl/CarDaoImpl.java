/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import az.perfect.dao.inter.CarDaoInterFace;
import az.perfect.entity.Car;
import az.perfect.entity.Category;
import az.perfect.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Behruz Tapdiqov
 */
public class CarDaoImpl extends AbstractDao implements CarDaoInterFace {

    public static int count;

    @Override
    public void update(Car c) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("update Car set car_name=?,car_marka=?,car_year=?,car_price=?,country_idd=?,category_idd=?"
                    + " where car_id=?");
            st.setString(1, c.getCar_name());
            st.setString(2, c.getCar_marka());
            st.setString(3, c.getCar_year());
            st.setInt(4, c.getCar_price());
            st.setInt(5, c.getCountry().getCountry_id());
            st.setInt(6, c.getCategory().getCategory_id());
            st.setInt(7, c.getCar_id());
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Car c) {

        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into Car (car_name,car_marka,car_year,car_price,country_idd,category_idd)"
                    + " values(?,?,?,?,?,?)");
            st.setString(1, c.getCar_name());
            st.setString(2, c.getCar_marka());
            st.setString(3, c.getCar_year());
            st.setInt(4, c.getCar_price());
            st.setInt(5, c.getCountry().getCountry_id());
            st.setInt(6, c.getCategory().getCategory_id());
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("delete from Car where car_id=?");
            st.setInt(1, id);
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Car getCar(int id) {
        Car c = null;
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select * from allinfo");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                c = getCar(rs);

            }

            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;

    }

    @Override
    public List<Car> getAllCar() {

        List<Car> list = new LinkedList<>();
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select * from allinfo");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(getCar(rs));
                count++;
            }
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Car getCar(ResultSet rs) throws SQLException {
        int car_id = rs.getInt("car_id");
        String car_name = rs.getString("car_name");
        String car_marka = rs.getString("car_marka");
        String car_year = rs.getString("car_year");
        int car_price = rs.getInt("car_price");
        int country_idd = rs.getInt("country_idd");
        String country_name = rs.getString("country_name");
        String category_name = rs.getString("category_name");
        int category_idd = rs.getInt("category_idd");
        return new Car(car_id, car_name, car_marka, car_year, car_price,
                new Country(country_idd, country_name), new Category(category_idd, category_name));

    }

}
