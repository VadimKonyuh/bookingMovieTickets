package com.vironIt.entity;

import java.util.Date;

public class Distribution {
    private long id;
    private long cinema_id;
    private long movie_id;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(long cinema_id) {
        this.cinema_id = cinema_id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distribution that = (Distribution) o;

        if (id != that.id) return false;
        if (cinema_id != that.cinema_id) return false;
        if (movie_id != that.movie_id) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (cinema_id ^ (cinema_id >>> 32));
        result = 31 * result + (int) (movie_id ^ (movie_id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id=" + id +
                ", cinema_id=" + cinema_id +
                ", movie_id=" + movie_id +
                ", date=" + date +
                '}';
    }
}
