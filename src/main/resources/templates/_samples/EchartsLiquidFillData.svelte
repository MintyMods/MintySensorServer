<script>
  import EchartsLiquidFill from "../_charts/echarts/liquidfill/EchartsLiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  let data;
  $: data = data;

  let instance;
  export const showConfig = (gridItem) => {
    instance.showConfig(gridItem);
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
