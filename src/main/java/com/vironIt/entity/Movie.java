package com.vironIt.entity;

import java.util.Date;

public class Movie {
    private long id;
    private String title;
    private String duration;
    private String description;
    private int age_braket;
    private Date end_of_rental;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getAge_braket() {
        return age_braket;
    }

    public void setAge_braket(int age_braket) {
        this.age_braket = age_braket;
    }

    public Date getEnd_of_rental() {
        return end_of_rental;
    }

    public void setEnd_of_rental(Date end_of_rental) {
        this.end_of_rental = end_of_rental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (age_braket != movie.age_braket) return false;
        if (!title.equals(movie.title)) return false;
        if (duration != null ? !duration.equals(movie.duration) : movie.duration != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        return end_of_rental != null ? end_of_rental.equals(movie.end_of_rental) : movie.end_of_rental == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + age_braket;
        result = 31 * result + (end_of_rental != null ? end_of_rental.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", age_braket=" + age_braket +
                ", end_of_rental=" + end_of_rental +
                '}';
    }
}
