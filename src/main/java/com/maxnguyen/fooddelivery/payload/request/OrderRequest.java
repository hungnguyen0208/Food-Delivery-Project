package com.maxnguyen.fooddelivery.payload.request;

public class OrderRequest {
    private int userId;
    private int restId;
    private int[] foodIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public int[] getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(int[] foodIds) {
        this.foodIds = foodIds;
    }
}
