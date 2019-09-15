<script>
    import './_scss/_readingsList.scss';

    import List, {
        Item,
        Graphic,
        Separator,
        Meta,
        Text,
        PrimaryText,
        SecondaryText
    } from '@smui/list';
    import Card from '@smui/card';
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
        storeTypes
    } from '../_stores/stores.js';

    let unsubscribeReadings;
    let unsubscribeTypes;
    let readings = [];
    let types = [];
    let items;
    let selectedType;
    let toggle = false;

    onMount(() => {
        subscribeToStores();
    });

    onDestroy(() => {
        unsubscribeReadings();
        unsubscribeTypes();
    });

    beforeUpdate(() => {
        if (toggle) {
            items = readings.filter(function(reading) {
                return reading.type.type === selectedType;
            });
            toggle = false;
        }
    });

    function subscribeToStores() {
        unsubscribeReadings = storeReadings.subscribe(value => {
            readings = value;
        });
        unsubscribeTypes = storeTypes.subscribe(value => {
            types = value;
        });
    }

    function getReadings(type) {
        selectedType = type;
        toggle = true;
    }

</script>


<div class="container1">
    <div class="accordion">
        <dl>
            {#each types as type, i (type.type)}
                <dt on:click={()=>selectedType = i}>
                    <Graphic class={type.icon}></Graphic>
                    <Text>{type.desc}</Text>                
                </dt>
            {/each}   
            {#if toggle}
<!--                <dd>-->
                    <List>
                      {#each items as item (item.id)}
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
<!--              </dd>-->
              {/if}         
        </dl>
    </div>
</div>
