package com.vironIt.entity;

public class Cinema {

    private Integer id;
    private String name;
    private String address;
    private Boolean isOpen;

    public Cinema() {
    }

    public Cinema(Integer id, String name, String address, Boolean isOpen) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isOpen = isOpen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema cinema = (Cinema) o;

        if (id != null ? !id.equals(cinema.id) : cinema.id != null) return false;
        if (name != null ? !name.equals(cinema.name) : cinema.name != null) return false;
        if (address != null ? !address.equals(cinema.address) : cinema.address != null) return false;
        return isOpen != null ? isOpen.equals(cinema.isOpen) : cinema.isOpen == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (isOpen != null ? isOpen.hashCode() : 0);
        return result;
    }
}
