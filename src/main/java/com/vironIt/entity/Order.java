package com.vironIt.entity;

import java.util.Date;

public class Order {
    private long id;
    private long user_id;
    private long seance_id;
    private long place_id;
    private Date date;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getSeance_id() {
        return seance_id;
    }

    public void setSeance_id(long seance_id) {
        this.seance_id = seance_id;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
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

        if (id != order.id) return false;
        if (user_id != order.user_id) return false;
        if (seance_id != order.seance_id) return false;
        if (place_id != order.place_id) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        result = 31 * result + (int) (seance_id ^ (seance_id >>> 32));
        result = 31 * result + (int) (place_id ^ (place_id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", seance_id=" + seance_id +
                ", place_id=" + place_id +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
