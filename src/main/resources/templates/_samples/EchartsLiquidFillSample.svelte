<script>
  import EchartsLiquidFill from "../_charts/echarts/EchartsLiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  export let data;
  $: data = data;

  let instance;
  export const showConfig = () => {
    instance.showConfig();
  };

  beforeUpdate(() => {
    if ($storeReadings.length > 0) {
      $storeReadings.some(reading => {
        if (reading.label.value === "HPWR Pump") {
          data = reading;
          return true;
        }
      });
    }
  });
</script>

<EchartsLiquidFill bind:this={instance} {data}/>
