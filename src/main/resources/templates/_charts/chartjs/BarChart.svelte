<style>
    #chart {
        pointer-events: none;
    }

</style>
<script>
    import WebSocket from '../../_components/WebSocket.svelte';
    import {
        onMount
    } from 'svelte';

    export let data;
    var ctx;
    var chart;

    function createChart() {
        ctx = document.getElementById('chart').getContext('2d');
        chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Core #0', 'Core #1', 'Core #2', 'Core #3', 'Core Max', 'CPU Package'],
                datasets: [{
                    label: 'CPU Temperature',
                    data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            steps: 10,
                            stepValue: 5,
                            max: 100
                        }
                    }]
                }
            }
        });
    }

    onMount(() => {
        createChart();
    });


    function onMessageReceived(event) {
        let readings = event.detail.content;
        //debugger
        for (let i = 0; i < readings.length; i++) {
            let reading = readings[i];
            let name = reading.label.value;
            let value = reading.value;

            if (name == "Core #0") {
                data[0] = value;
            } else if (name == "Core #1") {
                data[1] = value;
            } else if (name == "Core #2") {
                data[2] = value;
            } else if (name == "Core #3") {
                data[3] = value;
            } else if (name == "Core Max") {
                data[4] = value;
            } else if (name == "CPU Package") {
                data[5] = value;
            }
        }
        chart.data.datasets.data = data;
        chart.update();
    }

</script>

<canvas id="chart" width="2" height="1"></canvas>
<WebSocket on:event={onMessageReceived} channel='/events/' command='EVENTS' />
