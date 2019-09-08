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

    let types = [];
    let readings = [];
    let selectedType;

    function typesCallBack(content) {
        types = content;
    }

    function readingsCallBack(content) {
        readings = content;
    }

    function getReadings(type) {
        selectedType = type;
    }

</script>

<WebSocket bind:callback={typesCallBack} command="TYPES" />
{#if selectedType }
    <WebSocket bind:callback={readingsCallBack} parameters={selectedType} command="SENSOR_READINGS" />
{/if}

<div class="wrapper">
    
<List class="sensors">
    {#each types as type, i}
        <Item on:SMUI:action={getReadings(type)}>
<!--            <Graphic class=""><i class={type.icon}></i></Graphic>-->
            <Text>{type.desc}</Text>
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
