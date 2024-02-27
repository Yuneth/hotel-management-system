/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.CustomerDao;
import hotel.system.entity.CustomerEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO customers VALUES (?,?,?,?,?,?,?)",
                t.getCustomerId(),
                t.getFirstName(),
                t.getLastName(),
                t.getNic(),
                t.getAddress(),
                t.getContact(),
                t.isStatus());

    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE customers SET first_name=?, last_name=?, nic=?, address=?, contact=?, status=?  WHERE customer_id=?",
                t.getFirstName(),
                t.getLastName(),
                t.getNic(),
                t.getAddress(),
                t.getContact(),
                t.isStatus(),
                t.getCustomerId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE customers SET status=false WHERE customer_id = ?", id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customers WHERE customer_id = ?", id);
        while (rst.next()) {
            return new CustomerEntity(
                    rst.getString("customer_id"),
                    rst.getString("first_name"),
                    rst.getString("last_name"),
                    rst.getString("nic"),
                    rst.getString("address"),
                    rst.getString("contact"),
                    rst.getBoolean("status"));
        }
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customers");
        List<CustomerEntity> customerEntities = new ArrayList<>();

        while (rst.next()) {
            customerEntities.add(new CustomerEntity(
                    rst.getString("customer_id"),
                    rst.getString("first_name"),
                    rst.getString("last_name"),
                    rst.getString("nic"),
                    rst.getString("address"),
                    rst.getString("contact"),
                    rst.getBoolean("status")));
        }
        return customerEntities;
    }

}
