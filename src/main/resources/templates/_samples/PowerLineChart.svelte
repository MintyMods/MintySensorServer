<script>
  import LineChart from "../_charts/chartjs/LineChart.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let data = [];
  $: data = data;
  let caption = "Power";

  beforeUpdate(() => {
    if ($storeReadings.length > 0) {
      data = [];
      $storeReadings.forEach(function(reading, i) {
        let label = reading.label.value;
        if (
          $storeTypes[reading.type].name == "POWER" &&
          label.toUpperCase().includes("POWER")
        ) {
          data.push(reading);
        }
      });
    }
  });
</script>

  {#if data}
    <LineChart {caption} {data} />
  {/if}
