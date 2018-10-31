package com.vironIt.entity;

import java.util.Date;

public class Order {

    private Long id;
    private Long userId;
    private Long distributionId;
    private Long placeId;
    private Date date;
    private String status;

    public Order() {
    }

    public Order(Long id, Long userId, Long distributionId, Long placeId, Date date, String status) {
        this.id = id;
        this.userId = userId;
        this.distributionId = distributionId;
        this.placeId = placeId;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (distributionId != null ? !distributionId.equals(order.distributionId) : order.distributionId != null)
            return false;
        if (placeId != null ? !placeId.equals(order.placeId) : order.placeId != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (distributionId != null ? distributionId.hashCode() : 0);
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", distributionId=" + distributionId +
                ", placeId=" + placeId +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
