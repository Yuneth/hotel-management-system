/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.entity;

/**
 *
 * @author Yuneth Perera
 */
public class PackageEntity {
    
    private String packageId;
    private String name;
    private String description;
    private Double price;
    private boolean status;

    public PackageEntity() {
    }

    public PackageEntity(String packageId, String name, String description, Double price, boolean status) {
        this.packageId = packageId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    /**
     * @return the packageId
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId the packageId to set
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PackageEntity{" + "packageId=" + packageId + ", name=" + name + ", description=" + description + ", price=" + price + ", status=" + status + '}';
    }
    
    
    
}
