<script>
    import './_sensorlist.scss';
    import WebSocket from '../_components/WebSocket.svelte';
    import List, {
        Item,
        Graphic,
        Separator,
        Text,
        PrimaryText,
        SecondaryText
    } from '@smui/list';
    import Card from '@smui/card';
    import {
        onMount
    } from 'svelte';

    let sensors = [];
    let readings = [];
    let selectedSensor;
    $: selectedSensor = selectedSensor;

    function sensorsCallBack(content) {
        sensors = content;
    }

    function readingsCallBack(content) {
        readings = content;
    }

    function getReading(sensor) {
        selectedSensor = sensor;
    }

</script>

<WebSocket bind:callback={sensorsCallBack} command="SENSORS" />
{#if selectedSensor }
    <WebSocket bind:callback={readingsCallBack} parameters={selectedSensor} command="SENSOR_READINGS" />
{/if}

<div class="wrapper">
    
<List class="sensors">
    {#each sensors as sensor, i}
        <Item on:SMUI:action={() =>getReading(sensor)}>
            <Graphic class=""></Graphic>
            <Text>{sensor.label.description}</Text>
        </Item>
    {/each}
</List>

            
<List class="readings">
    {#each readings as { id, instance, label }, i}
        <Item>
            <Graphic class=""></Graphic>
            <Text>{label.description}</Text>
        </Item>
    {/each}
</List>
</div>
