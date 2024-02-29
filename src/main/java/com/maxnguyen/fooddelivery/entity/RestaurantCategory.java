package com.maxnguyen.fooddelivery.entity;

import com.maxnguyen.fooddelivery.entity.keys.KeyRestaurantCategory;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "restaurant_category")
public class RestaurantCategory {
    @EmbeddedId
    KeyRestaurantCategory keys;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    public KeyRestaurantCategory getKeys() {
        return keys;
    }

    public void setKeys(KeyRestaurantCategory keys) {
        this.keys = keys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
