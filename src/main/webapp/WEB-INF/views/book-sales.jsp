<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Bookstore</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="/css/catalogmdb.css" rel="stylesheet">

    

    <style type="text/css">
        .multiple-select-dropdown li [type=checkbox]+label {
            height: 1rem;
        }
    </style>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>

<body class="category-v1 hidden-sn white-skin animated">

    <tags:nav />


    <br/>
    <br/>
    <br/>
    <div class="container">

        <section class="section pt-4">
            <center>
                <h1>Book Sales</h1>
                <hr>
            </center>
        </section>
    </div>


<center>
    <div>

        <!--Section: Main panel-->
        <section class="mb-5">

            <!--Card-->
            <div class="card card-cascade narrower">

                <!--Section: Chart-->
                <section>

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-xl-5 col-lg-12 mr-0">

                            <!--Card image-->
                            <div class="view view-cascade gradient-card-header light-blue lighten-1">
                                <h2 class="h2-responsive mb-0">Sales</h2>
                            </div>
                            <!--/Card image-->

                            <!--Card content-->
                            <div class="card-body card-body-cascade pb-0">

                                <!--Panel data-->
                                <div class="row card-body pt-3">

                                    <!--First column-->
                                    <div class="col-md-6">

                                        <!--Date select-->
                                        <select class="mdb-select colorful-select dropdown-info md-form">
                                            <option value="">Choose time period</option>
                                            <option value="1">Today</option>
                                            <option value="2">Yesterday</option>
                                            <option value="3">Last 7 days</option>
                                            <option value="3">Last 30 days</option>
                                            <option value="3">Last week</option>
                                            <option value="3">Last month</option>
                                        </select>

                                        <!--Date pickers-->
                                        <br>
                                        <div class="md-form">
                                            <input placeholder="Selected date" type="text" id="from" class="form-control datepicker">
                                            <label for="from">From</label>
                                        </div>
                                        <div class="md-form">
                                            <input placeholder="Selected date" type="text" id="to" class="form-control datepicker">
                                            <label for="to">To</label>
                                        </div>


                                    </div>
                                    <!--/First column-->

                                    <!--Second column-->
                                    <div class="col-md-6 text-center">

                                        <!--Summary-->
                                        <p>Total sales: <strong>2000$</strong></p>
                                        <p>Average sales: <strong>100$</strong></p>
                                        <p>% Improvement from last week: </p>
                                        <p>Top 5 Sales by Book: <strong> </strong></p>


                                    </div>
                                    <!--/Second column-->
                                    <!--Grid column-->


                                </div>
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <h4 class="h4-responsive text-center mb-3">
                                            Sales by Genre
                                        </h4>

                                        <canvas id="doughnutChart"></canvas>
                                    </div>
                                </div>
                                </div>
                                <!--/Panel data-->

                            </div>
                            <!--/.Card content-->





                        <!--Grid column-->
                        <div class="col-xl-7 col-lg-12 mb-4">

                            <!--Card image-->
                            <div class="view view-cascade gradient-card-header blue-gradient">

                                <!-- Chart -->
                                <canvas id="lineChart" height="175"></canvas>

                            </div>
                            <!--/Card image-->

                        </div>
                        <!--Grid column-->
                    </div>
                </section>
            </div>


                </section>
                <!--Section: Chart-->



            </div>

        </section>
    </div>
</center>

<!--Footer-->
<tags:footer />
<!--/.Footer-->



    <!-- JQuery -->
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="/js/popper.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="/js/mdb.min.js"></script>

    <!-- Charts -->
    <script>
        // Small chart
        $(function () {
            $('.min-chart#chart-sales').easyPieChart({
                barColor: "#FF5252",
                onStep: function (from, to, percent) {
                    $(this.el).find('.percent').text(Math.round(percent));
                }
            });
        });

        //Main chart
        var ctxL = document.getElementById("lineChart").getContext('2d');
        var myLineChart = new Chart(ctxL, {
            type: 'line',
            data: {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [{
                    label: "My First dataset",
                    fillColor: "#fff",
                    backgroundColor: 'rgba(255, 255, 255, .3)',
                    borderColor: 'rgba(255, 255, 255)',
                    data: [0, 10, 5, 2, 20, 30, 45],
                }]
            },
            options: {
                legend: {
                    labels: {
                        fontColor: "#fff",
                    }
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display: true,
                            color: "rgba(255,255,255,.25)"
                        },
                        ticks: {
                            fontColor: "#fff",
                        },
                    }],
                    yAxes: [{
                        display: true,
                        gridLines: {
                            display: true,
                            color: "rgba(255,255,255,.25)"
                        },
                        ticks: {
                            fontColor: "#fff",
                        },
                    }],
                }
            }
        });
    </script>
    <script>
        $(function () {
            var data = {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [{
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(0,0,0,.15)",
                    data: [65, 59, 80, 81, 56, 55, 40],
                    backgroundColor: "#4CAF50",
                }, {
                    label: "My Second dataset",
                    fillColor: "rgba(255,255,255,.25)",
                    strokeColor: "rgba(255,255,255,.75)",
                    pointColor: "#fff",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(0,0,0,.15)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }]
            };


            var dataPie = [{
                value: 300,
                color: "#4caf50",
                highlight: "#66bb6a",
                label: "Google Chrome"
            }, {
                value: 50,
                color: "#03a9f4",
                highlight: "#29b6f6",
                label: "Edge"
            }, {
                value: 100,
                color: "#d32f2f",
                highlight: "#e53935",
                label: "Firefox"
            }]

            var option = {
                responsive: true,
                // set font color
                scaleFontColor: "#fff",
                // font family
                defaultFontFamily: "'Roboto', sans-serif",
                // background grid lines color
                scaleGridLineColor: "rgba(255,255,255,.1)",
                // hide vertical lines
                scaleShowVerticalLines: false,
            };

            // // Get the context of the canvas element we want to select
            // var ctx = document.getElementById("sales").getContext('2d');
            // var myLineChart = new Chart(ctx).Line(data, option); //'Line' defines type of the chart.

            // // Get the context of the canvas element we want to select
            // var ctx = document.getElementById("conversion").getContext('2d');
            // var myRadarChart = new Chart(ctx).Radar(data, option);

            // Get the context of the canvas element we want to select


            //pie
            var ctxP = document.getElementById("doughnutChart").getContext('2d');
            var myPieChart = new Chart(ctxP, {
                type: 'doughnut',
                data: {
                    labels: ["Sci-Fi", "Mystery", "Fantasy", "History"],
                    datasets: [
                        {
                            data: [160, 50, 80, 60],
                            backgroundColor: ["#4285F4", "#ffbb33", "#29b6f6", "#FF5252"],
                            hoverBackgroundColor: ["#6ea0f2", "#fec451", "#52c3f6", "#fa6e6e"]
                        }
                    ]
                },
                options: {
                    responsive: true
                }
            });


        });
    </script>

    <script>
        $(function () {
            $('.min-chart#chart-sales').easyPieChart({
                barColor: "#4caf50",
                onStep: function (from, to, percent) {
                    $(this.el).find('.percent').text(Math.round(percent));
                }
            });
        });
    </script>
    <script>
        var dataPie = [{
        value: 300,
        color: "#4caf50",
        highlight: "#66bb6a",
        label: "Google Chrome"
        }, {
        value: 50,
        color: "#03a9f4",
        highlight: "#29b6f6",
        label: "Edge"
        }, {
        value: 100,
        color: "#d32f2f",
        highlight: "#e53935",
        label: "Firefox"
        }]
    </script>

    <!--Initializations-->
    <script>
        // SideNav Initialization
        $(".button-collapse").sideNav();

        var container = document.querySelector('.custom-scrollbar');
        Ps.initialize(container, {
            wheelSpeed: 2,
            wheelPropagation: true,
            minScrollbarLength: 20
        });

        // Data Picker Initialization
        $('.datepicker').pickadate();

        // Material Select Initialization
        $(document).ready(function () {
            $('.mdb-select').material_select();
        });

        // Tooltips Initialization
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>
</body>
</html>