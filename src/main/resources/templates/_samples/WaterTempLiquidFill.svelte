<script>
  import LiquidFill from "../_charts/LiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  export let data;
  let instance;
  $: data;

  export function showConfig() {
    instance.showConfig();
  }

  beforeUpdate(() => {
    if ($storeReadings.length > 1) {
      $storeReadings.forEach(function(reading, i) {
        if (reading.label.value === "HPWR Pump") {
          data = reading;
        }
        data = data;
      });
    }
  });
</script>

<LiquidFill {data} bind:this={instance} />
