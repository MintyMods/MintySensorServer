<script>
    import './_scss/_sensorList.scss';

    import List, {
        Item,
        Graphic,
        Meta,
        Separator,
        Text,
        PrimaryText,
        SecondaryText
    } from '@smui/list';
    import {
        onMount
    } from 'svelte';
    import {
        onDestroy
    } from 'svelte';
    import {
        beforeUpdate
    } from 'svelte';
    import {
        storeReadings,
        storeSensors
    } from '../_stores/stores.js';

    let unsubscribeReadings;
    let unsubscribeSensors;
    let readings = [];
    let sensors = [];
    let types = [];
    let items;
    let selectedIndex;

    onMount(() => {
        subscribeToStores();
    });

    onDestroy(() => {
        unsubscribeReadings();
        unsubscribeSensors();
    });

    beforeUpdate(() => {
        if (selectedIndex) {
            items = readings.filter(function(reading) {
                return reading.sensor_index === selectedIndex;
            });
        }
    });

    function subscribeToStores() {
        unsubscribeReadings = storeReadings.subscribe(value => {
            readings = value;
        });
        unsubscribeSensors = storeSensors.subscribe(value => {
            sensors = value;
        });
    }

</script>

<div class="container1">
    <div class="accordion">
        <dl>
            {#each sensors as sensor, i (sensor.id)}
                <dt on:click={()=>selectedIndex = i}>{sensor.label.description}</dt>
            {/each}   
            {#if items}
                <dd>
                    <List>
                      {#each items as item, i (item.id)}
                        <Item>
                          <Graphic class={item.icon}/>
                          <Text>
                            <PrimaryText>{item.label.description}</PrimaryText>
                            <SecondaryText>{item.value} {item.unit}</SecondaryText>
                          </Text>
                          <Meta class="material-icons">{item.type.desc}</Meta>
                        </Item>
                      {/each}
                    </List>
              </dd>
              {/if}         
        </dl>
    </div>
</div>
