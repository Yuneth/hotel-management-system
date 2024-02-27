/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.PackageDao;
import hotel.system.entity.PackageEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class PackageDaoImpl implements PackageDao {

    @Override
    public boolean save(PackageEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO packages VALUES (?,?,?,?,?)",
                t.getPackageId(),
                t.getName(),
                t.getDescription(),
                t.getPrice(),
                t.isStatus());
    }

    @Override
    public boolean update(PackageEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE packages SET name=?, description=?, pricing=?,  status=?  WHERE package_id=?",
                t.getName(),
                t.getDescription(),
                t.getPrice(),
                t.isStatus(),
                t.getPackageId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE packages SET status=false WHERE package_id = ?", id);
    }

    @Override
    public PackageEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM packages WHERE package_id = ?", id);
        while (rst.next()) {
            return new PackageEntity(
                    rst.getString("package_id"),
                    rst.getString("name"),
                    rst.getString("description"),
                    rst.getDouble("pricing"),
                    rst.getBoolean("status"));
        }
        return null;
    }

    @Override
    public List<PackageEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM packages");
        List<PackageEntity> PackageEntities = new ArrayList<>();
        
        while (rst.next()) {
            PackageEntities.add(new PackageEntity(
                    rst.getString("package_id"),
                    rst.getString("name"),
                    rst.getString("description"),
                    rst.getDouble("pricing"),
                    rst.getBoolean("status")));
        }
        return PackageEntities;
    }
    
}
