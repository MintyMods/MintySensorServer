<script>
  import TempGauge from "../_charts/TempGauge.svelte";

  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  export let data;
  $: data;
  let instance;

  export function showConfig() {
    instance.showConfig();
  }

  beforeUpdate(() => {
    if ($storeReadings.length > 1) {
      $storeReadings.forEach(function(reading, i) {
        if (reading.label.value === "System1") {
          data = reading.value;
        }
        data = data;
      });
    }
  });
</script>

<TempGauge bind:this={instance} {data} />
