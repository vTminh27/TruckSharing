package com.example.trucksharing.util;

public class Util {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TruckSharing";

    public static final String TABLE_NAME_USER = "User";
    public static final String TABLE_NAME_TRUCK = "Truck";
    public static final String TABLE_NAME_ORDER = "DeliveryOrder";

    public static final String USER_ID = "user_id";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FULLNAME = "fullName";
    public static final String USER_PHONENUMBER = "phoneNumber";
    public static final String USER_AVATARNAME = "avatarName";

    public static final String TRUCK_ID = "truck_id";
    public static final String TRUCK_NAME = "truckName";
    public static final String TRUCK_IMAGE_NAME = "truckImageName";
    public static final String TRUCK_STATUS = "truckStatus";

    public static final String ORDER_ID = "order_id";
    public static final String ORDER_RECEIVER_NAME = "receiverName";
    public static final String ORDER_IMAGE_NAME = "imageName";
    public static final String ORDER_PICKUP_LOCATION = "pickupLocation";
    public static final String ORDER_PICKUP_DATE = "pickupDate";
    public static final String ORDER_PICKUP_TIME = "pickupTime";
    public static final String ORDER_GOOD_TYPE = "goodType";
    public static final String ORDER_VEHICLE_TYPE = "vehicleType";
    public static final String ORDER_DRIVER_NAME = "driverName";
    public static final String ORDER_WEIGHT = "weight";
    public static final String ORDER_WIDTH = "width";
    public static final String ORDER_HEIGHT = "height";
    public static final String ORDER_LENGTH = "length";
    public static final String ORDER_QUANTITY = "quantity";
}
