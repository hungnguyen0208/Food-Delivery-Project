package com.maxnguyen.fooddelivery.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "is_freeship")
    private boolean isFreeShip;
    @Column(name = "address")
    private String address;
    @Column(name = "open_date")
    private Date openDate;
    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurants;
    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> orders;

    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantCategory> restaurantCategories;
    @OneToMany(mappedBy = "restaurant")
    private Set<Promotion> promotions;

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<RestaurantCategory> getRestaurantCategories() {
        return restaurantCategories;
    }

    public void setRestaurantCategories(Set<RestaurantCategory> restaurantCategories) {
        this.restaurantCategories = restaurantCategories;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<RatingRestaurant> getRatingRestaurants() {
        return ratingRestaurants;
    }

    public void setRatingRestaurants(Set<RatingRestaurant> ratingRestaurants) {
        this.ratingRestaurants = ratingRestaurants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
