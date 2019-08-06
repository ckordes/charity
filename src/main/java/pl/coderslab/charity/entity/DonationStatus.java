package pl.coderslab.charity.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class DonationStatus {
    @Id
    @GeneratedValue
    private long id;
    private boolean pickedUp;
    private LocalDate createdDateEntry;
    private LocalDate pickedUpDate;
    @OneToOne
    private User user;

    @PrePersist
    public void createdOn(){
        createdDateEntry = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public LocalDate getCreatedDateEntry() {
        return createdDateEntry;
    }

    public void setCreatedDateEntry(LocalDate createdDateEntry) {
        this.createdDateEntry = createdDateEntry;
    }

    public LocalDate getPickedUpDate() {
        return pickedUpDate;
    }

    public void setPickedUpDate(LocalDate pickedUpDate) {
        this.pickedUpDate = pickedUpDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
