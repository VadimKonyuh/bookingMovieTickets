package com.vironIt.entity;

import java.util.Date;

public class Movie {

    private Long id;
    private String title;
    private String duration;
    private String description;
    private Integer ageRate;
    private Date endOfRental;

    public Movie() {
    }

    public Movie(Long id, String title, String duration, String description, Integer ageRate, Date endOfRental) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.ageRate = ageRate;
        this.endOfRental = endOfRental;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAgeRate() {
        return ageRate;
    }

    public void setAgeRate(Integer ageRate) {
        this.ageRate = ageRate;
    }

    public Date getEndOfRental() {
        return endOfRental;
    }

    public void setEndOfRental(Date endOfRental) {
        this.endOfRental = endOfRental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (duration != null ? !duration.equals(movie.duration) : movie.duration != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (ageRate != null ? !ageRate.equals(movie.ageRate) : movie.ageRate != null) return false;
        return endOfRental != null ? endOfRental.equals(movie.endOfRental) : movie.endOfRental == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ageRate != null ? ageRate.hashCode() : 0);
        result = 31 * result + (endOfRental != null ? endOfRental.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", ageRate=" + ageRate +
                ", endOfRental=" + endOfRental +
                '}';
    }
}
