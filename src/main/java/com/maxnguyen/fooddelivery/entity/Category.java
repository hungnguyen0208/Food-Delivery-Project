package com.maxnguyen.fooddelivery.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "category")
    private Set<Food> foodList;

    @OneToMany(mappedBy = "category")
    private Set<RestaurantCategory> restaurantCategories;

    public Set<RestaurantCategory> getRestaurantCategories() {
        return restaurantCategories;
    }

    public void setRestaurantCategories(Set<RestaurantCategory> restaurantCategories) {
        this.restaurantCategories = restaurantCategories;
    }

    public Set<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(Set<Food> foodList) {
        this.foodList = foodList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
