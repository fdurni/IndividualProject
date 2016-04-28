package com.feliciadurni.tt.chart;

/**
 * Created by felic on 4/28/2016.
 */
public class ChartData {

    int week =0;
    float squat_weight=0;
    float deadlift_weight=0;
    float bench_weight=0;

    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }

    public float getSquat_weight() {
        return squat_weight;
    }

    public void setSquat_weight(float squat_weight) {
        this.squat_weight = squat_weight;
    }

    public float getDeadlift_weight() {
        return deadlift_weight;
    }

    public void setDeadlift_weight(float deadlift_weight) {
        this.deadlift_weight = deadlift_weight;
    }

    public float getBench_weight() {
        return bench_weight;
    }

    public void setBench_weight(float bench_weight) {
        this.bench_weight = bench_weight;
    }
}
