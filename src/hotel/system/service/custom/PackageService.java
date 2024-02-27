/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.PackageDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface PackageService extends SuperService {
    
    String addPackage(PackageDto dto) throws Exception;

    String updatePackage(PackageDto dto) throws Exception;

    String deletePackage(String id) throws Exception;

    PackageDto getPackage(String id) throws Exception;

    List<PackageDto> getAll() throws Exception;
    
}
