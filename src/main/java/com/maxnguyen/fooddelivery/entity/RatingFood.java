package com.maxnguyen.fooddelivery.entity;

import jakarta.persistence.*;

@Entity(name = "rating_food")
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "ratingPoint")
    private int ratingPoint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
