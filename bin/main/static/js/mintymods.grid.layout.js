$(function () {

    Highcharts.chart('speed-container', {

            chart: {
                type: 'gauge',
                alignTicks: false,
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false
            },

            title: {
                text: 'Speedometer with dual axes'
            },

            pane: {
                startAngle: -150,
                endAngle: 150
            },

            yAxis: [{
                min: 0,
                max: 200,
                lineColor: '#339',
                tickColor: '#339',
                minorTickColor: '#339',
                offset: -25,
                lineWidth: 2,
                labels: {
                    distance: -20,
                    rotation: 'auto'
                },
                tickLength: 5,
                minorTickLength: 5,
                endOnTick: false
    }, {
                min: 0,
                max: 124,
                tickPosition: 'outside',
                lineColor: '#933',
                lineWidth: 2,
                minorTickPosition: 'outside',
                tickColor: '#933',
                minorTickColor: '#933',
                tickLength: 5,
                minorTickLength: 5,
                labels: {
                    distance: 12,
                    rotation: 'auto'
                },
                offset: -20,
                endOnTick: false
    }],

            series: [{
                name: 'Speed',
                data: [80],
                dataLabels: {
                    formatter: function () {
                        var kmh = this.y,
                            mph = Math.round(kmh * 0.621);
                        return '<span style="color:#339">' + kmh + ' km/h</span><br/>' +
                            '<span style="color:#933">' + mph + ' mph</span>';
                    },
                    backgroundColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                    [0, '#DDD'],
                    [1, '#FFF']
                ]
                    }
                },
                tooltip: {
                    valueSuffix: ' km/h'
                }
    }]

        },
        // Add some life
        function (chart) {
            setInterval(function () {
                if (chart.axes) { // not destroyed
                    var point = chart.series[0].points[0],
                        newVal,
                        inc = Math.round((Math.random() - 0.5) * 20);

                    newVal = point.y + inc;
                    if (newVal < 0 || newVal > 200) {
                        newVal = point.y - inc;
                    }

                    point.update(newVal);
                }
            }, 3000);

        });




    Highcharts.chart('half-pie-container', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'Browser<br>shares<br>2017',
            align: 'center',
            verticalAlign: 'middle',
            y: 40
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                dataLabels: {
                    enabled: true,
                    distance: -50,
                    style: {
                        fontWeight: 'bold',
                        color: 'white'
                    }
                },
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%'],
                size: '110%'
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            innerSize: '50%',
            data: [
            ['Chrome', 58.9],
            ['Firefox', 13.29],
            ['Internet Explorer', 13],
            ['Edge', 3.78],
            ['Safari', 3.42],
                {
                    name: 'Other',
                    y: 7.61,
                    dataLabels: {
                        enabled: false
                    }
            }
        ]
    }]
    });



    // Radialize the colors
    Highcharts.setOptions({
        colors: Highcharts.map(Highcharts.getOptions().colors, function (color) {
            return {
                radialGradient: {
                    cx: 0.5,
                    cy: 0.3,
                    r: 0.7
                },
                stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
            };
        })
    });

    // Build the chart
    Highcharts.chart('pie-container', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Browser market shares in January, 2018'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    connectorColor: 'silver'
                }
            }
        },
        series: [{
            name: 'Share',
            data: [
                {
                    name: 'Chrome',
                    y: 61.41
                },
                {
                    name: 'Internet Explorer',
                    y: 11.84
                },
                {
                    name: 'Firefox',
                    y: 10.85
                },
                {
                    name: 'Edge',
                    y: 4.67
                },
                {
                    name: 'Safari',
                    y: 4.18
                },
                {
                    name: 'Other',
                    y: 7.05
                }
        ]
    }]
    });


    Highcharts.chart('container-vu', {

            chart: {
                type: 'gauge',
                plotBorderWidth: 1,
                plotBackgroundColor: {
                    linearGradient: {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops: [
                [0, '#FFF4C6'],
                [0.3, '#FFFFFF'],
                [1, '#FFF4C6']
            ]
                },
                plotBackgroundImage: null,
                height: 200
            },

            title: {
                text: 'CPU Ghz'
            },

            pane: [{
                startAngle: -45,
                endAngle: 45,
                background: null,
                center: ['25%', '145%'],
                size: 300
    }, {
                startAngle: -45,
                endAngle: 45,
                background: null,
                center: ['75%', '145%'],
                size: 300
    }],

            tooltip: {
                enabled: false
            },

            yAxis: [{
                min: -0,
                max: 6,
                minorTickPosition: 'outside',
                tickPosition: 'outside',
                labels: {
                    rotation: 'auto',
                    distance: 20
                },
                plotBands: [{
                        from: 4,
                        to: 6,
                        color: '#C02316',
                        innerRadius: '100%',
                        outerRadius: '105%'
        }, {
                        from: 0,
                        to: 2,
                        color: '#00FF00',
                        innerRadius: '100%',
                        outerRadius: '105%'
        }
                           ],
                pane: 0,
                title: {
                    text: 'CORE 1<br/><span style="font-size:8px">Mhz</span>',
                    y: -40
                }
    }, {
                min: -0,
                max: 6,
                minorTickPosition: 'outside',
                tickPosition: 'outside',
                labels: {
                    rotation: 'auto',
                    distance: 20
                },
                plotBands: [{
                    from: 4,
                    to: 6,
                    color: '#C02316',
                    innerRadius: '100%',
                    outerRadius: '105%'
        }, {
                    from: 0,
                    to: 2,
                    color: '#00FF00',
                    innerRadius: '100%',
                    outerRadius: '105%'
        }],
                pane: 1,
                title: {
                    text: 'CORE 2<br/><span style="font-size:8px">Mhz</span>',
                    y: -40
                }
    }],

            plotOptions: {
                gauge: {
                    dataLabels: {
                        enabled: false
                    },
                    dial: {
                        radius: '100%'
                    }
                }
            },


            series: [{
                name: 'CORE 1',
                data: [-20],
                yAxis: 0
    }, {
                name: 'CORE 2',
                data: [-20],
                yAxis: 1
    }]

        },

        // Let the music play
        function (chart) {
            setInterval(function () {
                if (chart.series) { // the chart may be destroyed
                    var left = chart.series[0].points[0],
                        right = chart.series[1].points[0],
                        leftVal,
                        rightVal,
                        inc = (Math.random() - 0.5) * 3;

                    leftVal = left.y + inc;
                    rightVal = leftVal + inc / 3;
                    if (leftVal < -20 || leftVal > 6) {
                        leftVal = left.y - inc;
                    }
                    if (rightVal < -20 || rightVal > 6) {
                        rightVal = leftVal;
                    }

                    left.update(leftVal, false);
                    right.update(rightVal, false);
                    chart.redraw();
                }
            }, 500);

        });




    Highcharts.chart('container', {

            chart: {
                type: 'gauge',
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false
            },

            title: {
                text: 'Water Temp'
            },

            pane: {
                startAngle: -150,
                endAngle: 150,
                background: [{
                    backgroundColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                        [0, '#FFF'],
                        [1, '#333']
                    ]
                    },
                    borderWidth: 0,
                    outerRadius: '109%'
            }, {
                    backgroundColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                        [0, '#333'],
                        [1, '#FFF']
                    ]
                    },
                    borderWidth: 1,
                    outerRadius: '107%'
            }, {
                    // default background
            }, {
                    backgroundColor: '#DDD',
                    borderWidth: 0,
                    outerRadius: '105%',
                    innerRadius: '103%'
            }]
            },

            // the value axis
            yAxis: {
                min: 0,
                max: 200,

                minorTickInterval: 'auto',
                minorTickWidth: 1,
                minorTickLength: 10,
                minorTickPosition: 'inside',
                minorTickColor: '#666',

                tickPixelInterval: 30,
                tickWidth: 2,
                tickPosition: 'inside',
                tickLength: 10,
                tickColor: '#666',
                labels: {
                    step: 2,
                    rotation: 'auto'
                },
                title: {
                    text: 'km/h'
                },
                plotBands: [{
                    from: 0,
                    to: 120,
                    color: '#55BF3B' // green
            }, {
                    from: 120,
                    to: 160,
                    color: '#DDDF0D' // yellow
            }, {
                    from: 160,
                    to: 200,
                    color: '#DF5353' // red
            }]
            },

            series: [{
                name: 'Water Temperature',
                data: [80],
                tooltip: {
                    valueSuffix: 'degrees'
                }
        }]

        },
        // Add some life
        function (chart) {
            if (!chart.renderer.forExport) {
                setInterval(function () {
                    var point = chart.series[0].points[0],
                        newVal,
                        inc = Math.round((Math.random() - 0.5) * 20);

                    newVal = point.y + inc;
                    if (newVal < 0 || newVal > 200) {
                        newVal = point.y - inc;
                    }

                    point.update(newVal);

                }, 3000);
            }
        });


    var gaugeOptions = {

        chart: {
            type: 'solidgauge'
        },

        title: null,

        pane: {
            center: ['50%', '85%'],
            size: '140%',
            startAngle: -90,
            endAngle: 90,
            background: {
                backgroundColor: Highcharts.defaultOptions.legend.backgroundColor || '#EEE',
                innerRadius: '60%',
                outerRadius: '100%',
                shape: 'arc'
            }
        },

        tooltip: {
            enabled: false
        },

        // the value axis
        yAxis: {
            stops: [
                [0.1, '#55BF3B'], // green
                [0.5, '#DDDF0D'], // yellow
                [0.9, '#DF5353'] // red
            ],
            lineWidth: 0,
            minorTickInterval: null,
            tickAmount: 2,
            title: {
                y: -70
            },
            labels: {
                y: 16
            }
        },

        plotOptions: {
            solidgauge: {
                dataLabels: {
                    y: 5,
                    borderWidth: 0,
                    useHTML: true
                }
            }
        }
    };

    // The speed gauge
    var chartSpeed = Highcharts.chart('container-speed', Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 200,
            title: {
                text: 'GPU Mhz'
            }
        },

        credits: {
            enabled: false
        },

        series: [{
            name: 'Mhz',
            data: [80],
            dataLabels: {
                format: '<div style="text-align:center">' +
                    '<span style="font-size:25px">{y}</span><br/>' +
                    '<span style="font-size:12px;opacity:0.4">Mhz</span>' +
                    '</div>'
            },
            tooltip: {
                valueSuffix: ' mhz'
            }
        }]

    }));

    // The RPM gauge
    var chartRpm = Highcharts.chart('container-rpm', Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 5,
            title: {
                text: 'Fan RPM'
            }
        },

        series: [{
            name: 'Fan RPM',
            data: [1],
            dataLabels: {
                format: '<div style="text-align:center">' +
                    '<span style="font-size:25px">{y:.1f}</span><br/>' +
                    '<span style="font-size:12px;opacity:0.4">' +
                    '* 1000 / min' +
                    '</span>' +
                    '</div>'
            },
            tooltip: {
                valueSuffix: ' revolutions/min'
            }
        }]

    }));

    // Bring life to the dials
    setInterval(function () {
        // Speed
        var point,
            newVal,
            inc;

        if (chartSpeed) {
            point = chartSpeed.series[0].points[0];
            inc = Math.round((Math.random() - 0.5) * 100);
            newVal = point.y + inc;

            if (newVal < 0 || newVal > 200) {
                newVal = point.y - inc;
            }

            point.update(newVal);
        }

        // RPM
        if (chartRpm) {
            point = chartRpm.series[0].points[0];
            inc = Math.random() - 0.5;
            newVal = point.y + inc;

            if (newVal < 0 || newVal > 5) {
                newVal = point.y - inc;
            }

            point.update(newVal);
        }
    }, 2000);


    $('.demo-grid').masonry({
        // options
        itemSelector: '.grid-item',
        columnWidth: 200
    });





});
