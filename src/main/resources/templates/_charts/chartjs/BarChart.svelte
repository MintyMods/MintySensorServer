<canvas id="chart" width="2" height="1"></canvas>
<style>
    #chart {
        pointer-events: none;
    }

</style>
<script>
    import WebSocket from '../_components/WebSocket.svelte';    
    import {
        onMount
    } from 'svelte';

    var stompClient = null;
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
        var socket = new SockJS('https://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.debug = () => {};
        stompClient.connect({}, onConnected, onError);
        createChart();
    });

    function onConnected() {
        stompClient.subscribe('/readings', onMessageReceived);
    }

    function onError(error) {
        alert('Could not connect to WebSocket server. Please refresh this page to try again!');
    }

    function onMessageReceived(payload) {
        var message = JSON.parse(payload.body);

        if (message.type == 'TEMP') {
            var content = JSON.parse(message.response);
            if (content.name == "Core #0") {
                data[0] = content.value;
            } else if (content.name == "Core #1") {
                data[1] = content.value;
            } else if (content.name == "Core #2") {
                data[2] = content.value;
            } else if (content.name == "Core #3") {
                data[3] = content.value;
            } else if (content.name == "Core Max") {
                data[4] = content.value;
            } else if (content.name == "CPU Package") {
                data[5] = content.value;
            }
        }
        chart.data.datasets.data = data;
        chart.update();
    }

</script>
