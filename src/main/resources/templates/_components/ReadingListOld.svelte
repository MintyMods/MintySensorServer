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
    import {
        onMount,
        onDestroy,
        afterUpdate
    } from 'svelte';
    import {
        storeReadings,
        storeTypes
    } from '../_stores/stores.js';

    let readings = [];
    let types = [];
    let items;
    let selectedType;
    let toggle = false;

    afterUpdate(() => {
        update();
    });

    function update() {
        if ($storeReadings.length) {
            items = $storeReadings.filter(function(reading) {
                return reading.type.type === selectedType;
            });
            items = items;
        }
    }

    function getReadings(type) {
        toggle = false;
        selectedType = type;
        update();
        toggle = true;
    }


    function test() {
        items = [];
    }

</script>


<div class="container1">
    <div class="accordion">
        <dl>
            {#each $storeTypes as type, i (type.type)}
                <dt on:click={()=>getReadings(type.type)}>
                    <Graphic class="{type.icon}"></Graphic>
                    <Text>{type.desc}</Text>                
                </dt>
            {/each}   
            {#if items}
<!--                <dd>-->
                    <List>
                      {#each items as item (item.id + item.sensor_index)}
                        <Item>
                          <Graphic class="{item.icon}"/>
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
<button on:click={()=>test()}>Test</button>
