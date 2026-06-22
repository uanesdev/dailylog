package dev.uanes.dailylog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "daily_log")
@Data
public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private LocalDate date;

    private boolean walkCompleted;

    private boolean drinkWater;

    private boolean workoutCompleted;

    @Column(length = 500)
    private String observations;

    public DailyLog() {}

    public DailyLog(LocalDate data) {
        this.date = data;
    }

    public boolean isFullDay() {
        return walkCompleted && drinkWater && workoutCompleted;
    }

}
