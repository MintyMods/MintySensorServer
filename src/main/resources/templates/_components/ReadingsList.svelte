<script>
  //   import "./_scss/_readingsList.scss";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";
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
</script>

<div class="container1">
  <div class="accordion">
    <dl>
      {#each $storeTypes as type, i (type)}
        <dt on:click={() => (index = type.type)}>
          <Graphic class={type.icon} />
          <Text>{type.desc}</Text>
        </dt>
      {/each}
      {#if readings}
        <dd>
          <List>
            {#each readings as reading (reading.id + "_" + reading.index)}
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
            {:else}
              <div>Loading...</div>
            {/each}
          </List>
        </dd>
      {:else}
        <div></div>
      {/if}
    </dl>
  </div>
</div>
