<canvas id="doughnut" width="400" height="400"></canvas>


<script>
    import {
        onMount
    } from 'svelte';

    var stompClient = null;
    export let data;
    var ctx;
    var chart;

    function createChart() {
        ctx = document.getElementById("doughnut");
        chart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
                datasets: [{
                    label: '# of Votes',
                    data: [12, 19],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
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
                rotation: 1 * Math.PI,
                circumference: 1 * Math.PI
            }
        });
    }

    // onMount(() => {
    // var socket = new SockJS('https://localhost:8080/ws');
    // stompClient = Stomp.over(socket);
    // stompClient.connect({}, onConnected, onError);
    // createChart();
    // });
    //
    // function onConnected() {
    // stompClient.subscribe('/readings', onMessageReceived);
    // //stompClient.debug = () => {};
    // }
    //
    //
    // function onMessageReceived(payload) {
    // var message = JSON.parse(payload.body);
    //
    //
    // // chart.data.datasets.data = data;
    // //chart.update();
    // }

</script>
