<script>
  //   import "./_scss/_readingsList.scss";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";
  // import AutoComplete from "./AutoComplete.svelte";
  import List, {
    Item,
    Graphic,
    Separator,
    Meta,
    Text,
    PrimaryText,
    SecondaryText
  } from "@smui/list";

  let index;
  let readings;

  $: if (index) {
    readings = $storeReadings.filter(function(reading) {
      return reading.type === index;
    });
  }

  function getReadings(type) {
    return readings.filter(reading => reading.type === type.type);
  }
</script>



<div class="container1">
  <div class="accordion">
    <dl>
      {#each $storeTypes as type, i (type)}
        <dt on:click={() => (index = type.type)}>
          <Graphic class={type.icon} />
          <Text>{type.desc}</Text>
        </dt>
{#if readings}
          <List>
            {#each getReadings(type) as reading (reading.id + '_' + reading.index + '_' + type.type)}
              <Item>
                <Graphic class={reading.icon} />
                <Text>
                  <PrimaryText>{reading.label.desc}</PrimaryText>
                  <SecondaryText>{reading.value} {reading.unit}</SecondaryText>
                </Text>
                <Meta class="material-icons">
                  <i class={$storeTypes[reading.type].icon} />
                  {$storeTypes[reading.type].desc}
                </Meta>
              </Item>
            {/each}
          </List>
        {/if}
      {/each}
    </dl>
  </div>
</div>
