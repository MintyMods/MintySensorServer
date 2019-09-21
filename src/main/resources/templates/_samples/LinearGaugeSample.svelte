<script>
  import LinearGauge from "../_charts/canvas_gauges/LinearGauge.svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let caption = "CPU Temperature";
  let data;
  $: data = data;
  $: if ($storeReadings.length > 0) {
    $storeReadings.forEach(function(reading, i) {
      if (
        $storeTypes[reading.type].name == "TEMP" &&
        reading.label.desc.includes("Core Max")
      ) {
        data = reading;
      }
    });
  }
</script>

{#if data}
  <LinearGauge {data} />
{/if}
