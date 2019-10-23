<script>

  import {
    storeReadings,
    storeSensors,
    storeTypes
  } from "../_stores/main-state.js";
  import List, {
    Item,
    Graphic,
    Meta,
    Separator,
    Text,
    PrimaryText,
    SecondaryText
  } from "@smui/list";

  let index;
  let readings;
  $: readings = readings;
  let types;
  $: types = $storeTypes;

  $: if (index) {
    readings = $storeReadings.filter(function(reading) {
      return reading.index === index;
    });
  }
</script>

<div class="container1">
  <div class="accordion">
    <dl>
      {#each $storeSensors as sensor, i (sensor.id + sensor.instance)}
        <dt on:click={() => (index = i)}>{sensor.label.desc}</dt>
      {/each}
      {#if readings}
        <dd>
          <List>
            {#each readings as reading, i (reading.id + reading.index)}
              <Item>
                <Graphic class={reading.type.icon} title={reading.type.desc} />
                <Text>
                  <PrimaryText>{reading.label.desc}</PrimaryText>
                  <SecondaryText>{reading.value} {reading.unit}</SecondaryText>
                </Text>
                <Meta class="material-icons">{types[reading.type].desc}</Meta>
              </Item>
            {:else}
              <div>None</div>
            {/each}
          </List>
        </dd>
      {:else}
        <div>None</div>
      {/if}
    </dl>
  </div>
</div>
<!-- <svg class="sparkline" width="100" height="30" stroke-width="3"></svg>

<script>
  sparkline(document.querySelector(".sparkline"), [1, 5, 2, 4, 8, 3, 7]);
</script> -->