/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.entity;

/**
 *
 * @author Yuneth Perera
 */
public class RoomCategoryEntity {

    private String categoryId;
    private String categoryType;
    private String description;
    private String facilities;
    private boolean status;  

    public RoomCategoryEntity() {
    }

    public RoomCategoryEntity(String categoryId, String categoryType, String description, String facilities, boolean status) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
        this.description = description;
        this.facilities = facilities;
        this.status = status;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryType
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType the categoryType to set
     */
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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
     * @return the facilities
     */
    public String getFacilities() {
        return facilities;
    }

    /**
     * @param facilities the facilities to set
     */
    public void setFacilities(String facilities) {
        this.facilities = facilities;
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
        return "RoomCategoryEntity{" + "categoryId=" + categoryId + ", categoryType=" + categoryType + ", description=" + description + ", facilities=" + facilities + ", status=" + status + '}';
    }

    
    
}
