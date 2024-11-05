package com.ertedemo.domain.model.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "notification_tenants",
            joinColumns = @JoinColumn(name = "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "tenant_id")
    )
    private List<Tenant> tenants;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "date", nullable = false)
    private Date date;

    public Notification() {
    }

    public Notification(List<Tenant> tenants, Long postId, Date date) {
        this.tenants = tenants;
        this.postId = postId;
        this.date = date;
    }
}