/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.perfect.dao.impl;

import az.perfect.config.AbstractDao;
import static az.perfect.config.AbstractDao.connect;
import az.perfect.dao.inter.CarDaoInterFace;
import az.perfect.dao.inter.CountryDaoInterFace;
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
public class CountryDaoImpl extends AbstractDao implements CountryDaoInterFace {

    @Override
    public void update(Country t) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("update country set country_name=? where country_id=?");
            st.setString(1, t.getCountry_name());
            st.setInt(2, t.getCountry_id());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Country t) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into country (country_name) values(?)");
            st.setString(1, t.getCountry_name());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("delete from country where country_id=?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> list = new LinkedList<>();
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select *from country");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(getCountry(rs));
            }
            st.execute();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public Country getCountryById(int id) {
        Country c = null;
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select *from country where country_id=" + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c = getCountry(rs);
            }
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;

    }
      public static Country getCountry(ResultSet rs) throws SQLException {

        int country_id = rs.getInt("country_id");
        String country_name = rs.getString("country_name");
        Country c = new Country(country_id, country_name);
        return c;
    }
}
