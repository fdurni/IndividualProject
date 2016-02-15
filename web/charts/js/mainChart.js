/**
 * Created by felic on 2/14/2016.
 */
$(function () {
    $('#mainChart').highcharts({
        title: {
            text: 'Lift Progress',
            x: -20 //center
        },
        subtitle: {
            text: 'Squat, Deadlift, Bench',
            x: -20
        },

        colors: ['#50B432', '#f7a35c', '#058DC7'],

        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Pounds (lbs)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'lbs'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Squat',
            data: [185, 195, 200, 205, 215, 245, 245, 265, 275, 285, 285, 285]
        }, {
            name: 'Deadlift',
            data: [200, 200, 205, 225, 225, 250, 255, 265, 270, 280, 300, 300]
        }, {
            name: 'Bench',
            data: [115, 115, 125, 125, 125, 135, 135, 135, 145, 145, 145, 145]
        }]
    });
});