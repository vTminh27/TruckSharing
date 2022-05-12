package com.example.trucksharing.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {

    int orderId;
    int userId;

    String receiverName;
    String imageName;
    String pickupLocation;
    String pickupDate;
    String pickupTime;
    String goodType;
    String vehicleType;
    String driverName;

    Double weight;
    Double width;
    Double height;
    Double length;
    Integer quantity;

    public Order(int userId, String receiverName, String imageName, String pickupLocation, String pickupDate, String pickupTime, String goodType, String vehicleType, String driverName, Double weight, Double width, Double height, Double length, Integer quantity) {
        this.userId = userId;
        this.receiverName = receiverName;
        this.imageName = imageName;
        this.pickupLocation = pickupLocation;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.goodType = goodType;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.quantity = quantity;
    }

    public Order() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String shareContent() {
        return
                "Order information: \n" +
                        "To: " + this.getReceiverName() + "\n" +
                        "Good type: " + this.getGoodType() + "\n" +
                        "Weight: " + this.getWeight().toString() + "\n" +
                        "Height: " + this.getHeight().toString() + "\n" +
                        "Width: " + this.getWidth().toString() + "\n" +
                        "Length: " + this.getLength().toString() + "\n" +
                        "Vehicle type: " + this.getVehicleType() + "\n";
    }
}
