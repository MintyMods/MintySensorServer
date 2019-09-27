<script>
  import BarChart from "../_charts/chartjs/BarChart.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let data = [];
  let labels = [];
  $: data = data;
  $: labels = labels;
  let caption = "Temperatures";
  let instance;

  export function showConfig() {
    instance.showConfig();
  }

  beforeUpdate(() => {
    if ($storeReadings.length > 0) {
      data = [];
      labels = [];
      $storeReadings.forEach(function(reading, i) {
        let label = reading.label.value;
        if (
          $storeTypes[reading.type].name == "TEMP" &&
          (label.includes("CPU") || label.includes("GPU"))
        ) {
          data.push(reading.value);
          labels.push(reading.label.desc);
        }
      });
    }
  });

  export const open = function() {
    alert("Open");
  };
</script>

{#if data}
  <BarChart bind:this={instance} {caption} {data} {labels} />
{/if}
