package com.vironIt.entity;

public class Seat {
    private long id;
    private int row;
    private int place;
    private boolean status;
    private long cinema_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(long cinema_id) {
        this.cinema_id = cinema_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != seat.id) return false;
        if (row != seat.row) return false;
        if (place != seat.place) return false;
        if (status != seat.status) return false;
        return cinema_id == seat.cinema_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + row;
        result = 31 * result + place;
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (int) (cinema_id ^ (cinema_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", place=" + place +
                ", status=" + status +
                ", cinema_id=" + cinema_id +
                '}';
    }
}
