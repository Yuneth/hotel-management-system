/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.entity;

/**
 *
 * @author Yuneth Perera
 */
public class RoomEntity {

    private String roomId;
    private String roomNo;
    private String categoryId;
    private String availabilityStatus;
    private Double price;
    private boolean status;  

    public RoomEntity() {
    }

    public RoomEntity(String roomId, String roomNo, String categoryId, String availabilityStatus, Double price, boolean status) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.categoryId = categoryId;
        this.availabilityStatus = availabilityStatus;
        this.price = price;
        this.status = status;
    }

    /**
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomNo
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
     * @return the availabilityStatus
     */
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     * @param availabilityStatus the availabilityStatus to set
     */
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
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
        return "RoomEntity{" + "roomId=" + roomId + ", roomNo=" + roomNo + ", categoryId=" + categoryId + ", availabilityStatus=" + availabilityStatus + ", price=" + price + ", status=" + status + '}';
    }

    
}
