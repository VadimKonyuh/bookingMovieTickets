package com.vironIt.entity;

public class Seat {

    private Integer id;
    private Integer row;
    private Integer place;
    private Boolean isFree;
    private Cinema cinema;

    public Seat() {
    }

    public Seat(Integer id, Integer row, Integer place, Boolean isFree, Cinema cinema) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.isFree = isFree;
        this.cinema = cinema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != null ? !id.equals(seat.id) : seat.id != null) return false;
        if (row != null ? !row.equals(seat.row) : seat.row != null) return false;
        if (place != null ? !place.equals(seat.place) : seat.place != null) return false;
        if (isFree != null ? !isFree.equals(seat.isFree) : seat.isFree != null) return false;
        return cinema != null ? cinema.equals(seat.cinema) : seat.cinema == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        result = 31 * result + (cinema != null ? cinema.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", place=" + place +
                ", isFree=" + isFree +
                ", cinema=" + cinema +
                '}';
    }
}
