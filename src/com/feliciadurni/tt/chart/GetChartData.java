package com.feliciadurni.tt.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.feliciadurni.tt.chart.ChartData;

import com.feliciadurni.tt.entity.Exercise;
import com.feliciadurni.tt.entity.Routine;
import com.feliciadurni.tt.entity.RoutineExercise;
import com.feliciadurni.tt.persistence.ExerciseDao;
import com.feliciadurni.tt.persistence.RoutineDao;
import com.feliciadurni.tt.persistence.RoutineExerciseDao;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by felic on 4/28/2016.
 */
public class GetChartData {

    private final Logger log = Logger.getLogger(this.getClass());

    public String GenerateJSonChartDataYearWisePassPercentage(String jsonp) throws JSONException {

        String chartType = jsonp;

        JSONObject finalJSonObj = new JSONObject();

        ChartData cd;

        ArrayList<ChartData> chartDataArray = new ArrayList<ChartData>();

        RoutineDao routineDao = new RoutineDao();

        List<Routine> routines = routineDao.getAllRoutines();

        for (Routine routine : routines) {

            Set<RoutineExercise> routineExercises = routine.getRoutineExercises();

            cd = new ChartData();

            for (RoutineExercise routineExercise : routineExercises) {

                Integer weight = routineExercise.getActualWeight();
                String exerciseName = routineExercise.getExercise().getExerciseName();
                Integer week = routineExercise.getRoutine().getWeek();

                if (exerciseName.equals("Squat")) {

                    cd.setSquat_weight(weight);
                } else if (exerciseName.equals("Deadlift")) {

                    cd.setDeadlift_weight(weight);
                } else if (exerciseName.equals("Bench Press")) {

                    cd.setBench_weight(weight);
                }

                cd.setWeek(week);
            }
            chartDataArray.add(cd);
        }

        JSONArray chartData = new JSONArray();
        JSONArray xaxisArr = new JSONArray();

        JSONObject xaxisObj = new JSONObject();

        JSONObject dataObj = new JSONObject();

        JSONArray squat_weight = new JSONArray();
        JSONArray deadlift_weight = new JSONArray();
        JSONArray bench_weight = new JSONArray();

        for (int i = 0; i < chartDataArray.size(); i++) {

            xaxisArr.put(chartDataArray.get(i).getWeek());

            squat_weight.put(chartDataArray.get(i).getSquat_weight());
            deadlift_weight.put(chartDataArray.get(i).getDeadlift_weight());
            bench_weight.put(chartDataArray.get(i).getBench_weight());
        }

        xaxisObj.put("category", xaxisArr);

        chartData.put(xaxisObj);

        dataObj = new JSONObject();
        dataObj.put("name", "Squat");
        dataObj.put("color", "#F39C11");
        dataObj.put("data", squat_weight);
        chartData.put(dataObj);

        dataObj = new JSONObject();
        dataObj.put("name", "Deadlift");
        dataObj.put("color", "#01A65A");
        dataObj.put("data", deadlift_weight);
        chartData.put(dataObj);

        dataObj = new JSONObject();
        dataObj.put("name", "Bench Press");
        dataObj.put("color", " #5DBCD2");
        dataObj.put("data", bench_weight);
        chartData.put(dataObj);

        finalJSonObj.put(chartType, chartData);

        String tempStr = jsonp + "(" + finalJSonObj.toString() + ")";

        return tempStr;
    }
}
