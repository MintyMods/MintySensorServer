<script>
  import JustGage from "../_charts/JustGage.svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let caption = "GPU Temperature";
  let data;
  $: data = data;

  $: if ($storeReadings.length > 0) {
    $storeReadings.forEach(function(reading, i) {
      if (
        $storeTypes[reading.type].name == "CLOCK" &&
        reading.label.desc.includes("Core #0 Clock")
      ) {
        data = reading;
      }
    });
  }
</script>

{#if data}
  <JustGage {data} max={6000}/>
{/if}
