package pl.wsb.fitnesstracker.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Statistics statistics;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<HealthMetrics> healthMetrics = new HashSet<>();

    
    public User() {
    }

    public User(String firstName, String lastName, String email, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public Set<HealthMetrics> getHealthMetrics() {
        return healthMetrics;
    }

    public void setHealthMetrics(Set<HealthMetrics> healthMetrics) {
        this.healthMetrics = healthMetrics;
    }
    
    public void setStatistics(Statistics statistics) {
        if (statistics == null) {
            if (this.statistics != null) {
                this.statistics.setUser(null);
            }
        } else {
            statistics.setUser(this);
        }
        this.statistics = statistics;
    }

    public void addHealthMetric(HealthMetrics metric) {
        healthMetrics.add(metric);
        metric.setUser(this);
    }

    public void removeHealthMetric(HealthMetrics metric) {
        healthMetrics.remove(metric);
        metric.setUser(null);
    }
}