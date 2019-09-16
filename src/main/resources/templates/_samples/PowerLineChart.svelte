<style>
    .TempsBarChart {
        height: 768px;
        position: relative;
        display: inline-block;
        width: 1024px;
    }

</style>

<script>
    import BarChart from '../_charts/chartjs/LineChart.svelte';
    import {
        beforeUpdate,
        afterUpdate
    } from 'svelte';
    import {
        storeReadings
    } from '../_stores/stores.js';

    let data = [];
    $: data = data;
    let caption = "Power";

    afterUpdate(() => {
        if ($storeReadings.length > 1) {
            data = [];
            $storeReadings.forEach(function(reading, i) {
                let label = reading.label.value;
                if (reading.type.name == 'POWER' && label.toUpperCase().includes('POWER')) {
                    data.push(reading);
                }
            });
        }
    });

</script>

<div class="TempsBarChart">
    {#if data}
        <BarChart {caption} {data} ></BarChart>
    {/if}
</div>
