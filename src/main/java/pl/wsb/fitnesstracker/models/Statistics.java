package pl.wsb.fitnesstracker.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "totalTrainings")
    private Integer totalTrainings;

    @Column(name = "totalDistance")
    private Double totalDistance;

    @Column(name = "totalCaloriesBurned")
    private Integer totalCaloriesBurned;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;

    
    public Statistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalTrainings() {
        return totalTrainings;
    }

    public void setTotalTrainings(Integer totalTrainings) {
        this.totalTrainings = totalTrainings;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(Integer totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}