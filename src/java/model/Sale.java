package model;
// Generated Jun 3, 2017 10:54:16 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Sale generated by hbm2java
 */
public class Sale  implements java.io.Serializable {


     private Integer uid;
     private Date date;
     private int restaurantUid;
     private int itemUid;
     private int quantity;

    public Sale() {
    }

    public Sale(Date date, int restaurantUid, int itemUid, int quantity) {
       this.date = date;
       this.restaurantUid = restaurantUid;
       this.itemUid = itemUid;
       this.quantity = quantity;
    }
   
    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public int getRestaurantUid() {
        return this.restaurantUid;
    }
    
    public void setRestaurantUid(int restaurantUid) {
        this.restaurantUid = restaurantUid;
    }
    public int getItemUid() {
        return this.itemUid;
    }
    
    public void setItemUid(int itemUid) {
        this.itemUid = itemUid;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


