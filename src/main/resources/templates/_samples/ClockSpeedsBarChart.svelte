<style>
    .chart {
        height: 768px;
        position: relative;
        display: inline-block;
        width: 1024px;
    }

</style>

<script>
    import BarChart from '../_charts/chartjs/BarChart.svelte';
    import {
        beforeUpdate,
        afterUpdate
    } from 'svelte';
    import {
        storeReadings,
        storeTypes
    } from '../_stores/stores.js';

    let data = [];
    let labels = [];
    $: data = data;
    $: labels = labels;
    let caption = "Clock Speeds";

    afterUpdate(() => {
        if ($storeReadings.length > 1) {
            data = [];
            labels = [];
            $storeReadings.forEach(function(reading, i) {
                let label = reading.label.value;
                let type = $storeTypes[reading.type];
                if (type.name == 'CLOCK' && (label.includes('Core') || label.includes('GPU'))) {
                    data.push(reading.value);
                    labels.push(reading.label.description);
                }
            });
        }
    });

</script>

<div class="chart">
    {#if data}
        <BarChart {caption} {data} {labels}></BarChart>
    {/if}
</div>
