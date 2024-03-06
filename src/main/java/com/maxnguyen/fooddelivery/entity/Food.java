package com.maxnguyen.fooddelivery.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String desccription;
    @Column(name = "image")
    private String image;
    @Column(name = "time_ship")
    private String timeShip;
    @Column(name = "price")
    private double price;
    @Column(name = "is_freeship")
    private boolean isFreeShip;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;
    @OneToMany(mappedBy = "food")
    private Set<RatingFood> ratingFoods;

    @OneToMany(mappedBy = "food")
    private Set<OrderItem> orderItems;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<RatingFood> getRatingFoods() {
        return ratingFoods;
    }

    public void setRatingFoods(Set<RatingFood> ratingFoods) {
        this.ratingFoods = ratingFoods;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
