package com.andrel.parkingsystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "used_spaces")
public class UsedSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private ParkingSpace parkingSpace;

    @Column(nullable = false)
    private LocalDateTime checkin;

    @Column
    private LocalDateTime checkout;

    @Column
    private Integer value;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    public UsedSpace() {
        this.createdAt = LocalDateTime.now();
    }

    public UsedSpace(LocalDateTime checkin, ParkingSpace parkingSpace) {
        this.checkin = checkin;
        this.parkingSpace = parkingSpace;
        this.createdAt = LocalDateTime.now();
    }

    public UsedSpace(LocalDateTime checkin, LocalDateTime checkout, Integer value, ParkingSpace parkingSpace) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.value = value;
        this.parkingSpace = parkingSpace;
        this.createdAt = LocalDateTime.now();
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
