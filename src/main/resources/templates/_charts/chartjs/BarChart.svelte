<style>
    .canvas-wrapper {
        position: relative;
        pointer-events: none;
        width: 400px;
        height: 400px;
    }

</style>
<script>
    import {
        onMount,
        beforeUpdate,
        afterUpdate
    } from 'svelte';

    export let data = [];
    export let labels = [];
    export let caption = "";
    export let width = 1;
    export let height = 2;
    export let backgroundColor;
    export let borderColor;

    export let id = "chart-" + Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10);
    let ctx;
    let chart;
    $: data;
    $: labels;

    onMount(() => {
        createChart();
        setColors();
    });

    beforeUpdate(() => {
        if (data.length > 0) {
            if (backgroundColor.length === 0) setColors();
            chart.data.labels = labels;
            chart.data.datasets[0].data = data;
            chart.data.datasets[0].backgroundColor = backgroundColor;
            chart.data.datasets[0].borderColor = borderColor;
            chart.update();
        }
    });

    function setColors() {
        backgroundColor = [];
        borderColor = [];
        for (let i = 0; i < data.length; i++) {
            let r = (Math.round(Math.random() * 127) + 127);
            let g = (Math.round(Math.random() * 127) + 127);
            let b = (Math.round(Math.random() * 127) + 127);
            backgroundColor.push(`rgba(${r},${g},${b}, 0.5)`);
            borderColor.push(`rgba(${r},${g},${b}, 1)`);
        }
    }

    function createChart() {
        ctx = document.getElementById(id).getContext('2d');
        chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels,
                datasets: [{
                    label: caption,
                    data,
                    borderWidth: 1
                }]
            },
            options: {
                responsiveAnimationDuration: 10,
                responsive: true,
                maintainAspectRatio: false
            }
        });
    }

</script>

<div class="canvas-wrapper">
    <canvas width="1" height="1" id={id}></canvas>
</div>
