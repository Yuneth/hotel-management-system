/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.controller;

import hotel.system.dto.PackageDto;
import hotel.system.service.ServiceFactory;
import hotel.system.service.custom.PackageService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class PackageController {
    
    private PackageService packageService = (PackageService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.PACKAGE);
    
    public String savePackage(PackageDto packageDto) throws Exception {
        return packageService.addPackage(packageDto);
    }

    public String updatePackage(PackageDto packageDto) throws Exception {
        return packageService.updatePackage(packageDto);
    }

    public String deletePackage(String id) throws Exception {
        return packageService.deletePackage(id);
    }

    public PackageDto getPackage(String id) throws Exception {
        return packageService.getPackage(id);
    }

    public List<PackageDto> getAllPackage() throws Exception {
        return packageService.getAll();
    }
    
}
