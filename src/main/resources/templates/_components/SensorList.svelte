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
    let sendSocket = false;
    $: selectedSensor = selectedSensor;

    function sensorsCallBack(event) {
        sensors = event.detail.content;
    }

    function readingsCallBack(event) {
        sendSocket = false;
        readings = event.detail.content;
    }

    function getReading(sensor) {
        selectedSensor = sensor;
        sendSocket = true;
    }

</script>

<WebSocket on:event={sensorsCallBack} command="SENSORS" />

<!--{#if sendSocket}-->
<WebSocket on:event={readingsCallBack} parameters={selectedSensor} command="READINGS_BY_SENSOR" />
<!--{/if}-->

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
    {#each readings as reading, i}
        <Item>
            <Graphic class="{reading.icon}"></Graphic>
            <Text>{reading.label.description}</Text>
        </Item>
    {/each}
</List>
</div>
