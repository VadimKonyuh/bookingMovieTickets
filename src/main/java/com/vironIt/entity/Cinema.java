package com.vironIt.entity;

public class Cinema {

    private long id;
    private String name;
    private String address;
    private boolean is_active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema cinema = (Cinema) o;

        if (id != cinema.id) return false;
        if (is_active != cinema.is_active) return false;
        if (!name.equals(cinema.name)) return false;
        return address.equals(cinema.address);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (is_active ? 1 : 0);
        return result;
    }
}
