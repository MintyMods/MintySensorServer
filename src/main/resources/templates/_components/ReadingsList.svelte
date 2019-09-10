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
    let sendSocket = false;

    function typesCallBack(event) {
        types = event.detail.content;
    }

    function readingsCallBack(event) {
        readings = event.detail.content;
        sendSocket = false;
    }

    function getReadings(type) {
        selectedType = type;
        sendSocket = true;
    }

</script>

<WebSocket on:event={typesCallBack} command="TYPES" />
{#if sendSocket }
    <WebSocket on:event={readingsCallBack} parameters={selectedType} command="READINGS_BY_TYPE" />
{/if}

<div class="wrapper">
    
<List class="types">
    {#each types as type, i}
        <Item on:SMUI:action={()=>getReadings(type)}>
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
