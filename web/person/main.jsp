<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/7/2016
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Content Type -->
<c:import url="../contentType.jsp"/>
<html>
  <c:import url="head.jsp"/>
  <body class="hold-transition skin-blue sidebar-mini">

      <!-- wrapper -->
      <div class="wrapper">

          <!-- Main Header -->
          <c:import url="header.jsp"/>

          <!-- Left side column. contains the logo and sidebar -->
          <c:import url="sidebar.jsp"/>

          <!-- Page content -->
          <c:import url="main-content.jsp"/>

          <!-- Main Footer -->
          <c:import url="footer.jsp"/>

      </div>

      <!-- REQUIRED JS SCRIPTS -->
      <c:import url="include.jsp"/>

  </body>
</html>
<script type="text/javascript">
    $(function() {
        generateChart();
    });
    function weightlifted(json) {
        $(function () {
            var len = json.weightlifted.length
            i = 0;
            var options = {
                chart: {
                    type: 'line'
                },
                credits: {
                    enabled: false
                },
                title: {
                    text: 'Weight Lifted'
                },
                subtitle: {
                    text: 'Squat, Deadlift, Bench',
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Weight (lbs)'
                    }
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                xAxis: {
                    categories: []
                },
                series: []
            }
            for (i; i < len; i++) {
                if (i === 0) {
                    var dat = json.weightlifted[i].category,
                            lenJ = dat.length,
                            j = 0,
                            tmp;
                    for (j; j < lenJ; j++) {
                        options.xAxis.categories.push(dat[j]);
                    }
                } else {
                    options.series.push(json.weightlifted[i]);
                }
            }
            $('#placeholder').highcharts(options);
        });
    }
    function generateChart() {
        chartType="weightlifted";
        $("#placeholder").text("");
        $.ajax({
            type: "GET",
            url:"/person/GetChartDetails?jsonp="+chartType,
            dataType: 'jsonp',
            jsonpCallback: chartType, // the function to call
            error: function () {
                alert("Error occured generating chart");
            }
        });
    }
</script>
