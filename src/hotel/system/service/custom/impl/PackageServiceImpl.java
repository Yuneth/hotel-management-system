/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.PackageDao;
import hotel.system.dto.PackageDto;
import hotel.system.entity.PackageEntity;
import hotel.system.service.custom.PackageService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class PackageServiceImpl implements PackageService {
    
    private PackageDao packageDao = (PackageDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.PACKAGE);

    @Override
    public String addPackage(PackageDto dto) throws Exception {
        PackageEntity packageEntity = new PackageEntity(
                dto.getPackageId(), dto.getName(), dto.getDescription(), dto.getPrice(), dto.isStatus());

        if (packageDao.save(packageEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updatePackage(PackageDto dto) throws Exception {
        PackageEntity packageEntity = new PackageEntity(
                dto.getPackageId(), dto.getName(), dto.getDescription(), dto.getPrice(), dto.isStatus());

        if (packageDao.update(packageEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deletePackage(String id) throws Exception {
        if (packageDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public PackageDto getPackage(String id) throws Exception {
        PackageEntity entity = packageDao.get(id);
        if (entity != null) {
            return new PackageDto(entity.getPackageId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.isStatus());
        }

        return null;
    }

    @Override
    public List<PackageDto> getAll() throws Exception {
        List<PackageDto> packageDtos = new ArrayList<>();
        List<PackageEntity> packageEntities = packageDao.getAll();
        for (PackageEntity entity : packageEntities) {
            packageDtos.add(new PackageDto(entity.getPackageId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.isStatus()));
        }
        return packageDtos;
    }
    
    
    
}
