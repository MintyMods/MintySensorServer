<script>
  import RadialGauge from "../_charts/canvas_gauges/RadialGauge.svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let caption = "GPU Temperature";
  let data;
  $: data = data;

  $: if ($storeReadings.length > 0) {
    $storeReadings.forEach(function(reading, i) {
      if (
        $storeTypes[reading.type].name == "OTHER" &&
        reading.label.desc.includes("Virtual Memory Commited")
      ) {
        data = reading;
      }
    });
  }
</script>

{#if data}
  <RadialGauge {data} />
{/if}
