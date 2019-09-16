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
       let selectedIndex;

       onMount(() => {
           subscribeToStores();
       });

       onDestroy(() => {
           unsubscribeReadings();
           unsubscribeTypes();
       });

       beforeUpdate(() => {
           if (selectedIndex) {
               items = readings.filter(function(reading) {
                   return reading.type === selectedIndex;
               });
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

   </script>

   <div class="container1">
       <div class="accordion">
           <dl>
               {#each types as type, i (type)}
                <dt on:click={()=>selectedIndex = i}>
                    <Graphic class={type.icon}></Graphic>
                    <Text>{type.name}</Text>                
                </dt>                
            {/each}   
            {#if items}
                <dd>
                    <List>
                      {#each items as item, i (item.id)}
                        <Item>
                            <Graphic class={item.icon}></Graphic>
                          <Text>
                            <PrimaryText>{item.label.description}</PrimaryText>
                            <SecondaryText>{item.value} {item.unit}</SecondaryText>
                          </Text>
                          <Meta class="material-icons"><i class={types[item.type].icon}></i>  {types[item.type].desc}</Meta>
                        </Item>
                      {/each}
                    </List>
              </dd>
              {/if}         
        </dl>
    </div>
</div>
