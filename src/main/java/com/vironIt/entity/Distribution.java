package com.vironIt.entity;

import java.util.Date;

public class Distribution {

    private Long id;
    private Long cinemaId;
    private Long movieId;
    private Date date;

    public Distribution() {
    }

    public Distribution(Long id, Long cinemaId, Long movieId, Date date) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cinemaId != null ? !cinemaId.equals(that.cinemaId) : that.cinemaId != null) return false;
        if (movieId != null ? !movieId.equals(that.movieId) : that.movieId != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cinemaId != null ? cinemaId.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", movieId=" + movieId +
                ", date=" + date +
                '}';
    }
}
