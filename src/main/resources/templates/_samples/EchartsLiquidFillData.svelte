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
<style>
  .chart {
    /* position: relative;
    display: inline-flex; */
    width: 100%;
    height: 100%;

  }
</style>
<div class="chart">
<EchartsLiquidFill on:click={showConfig} bind:this={instance} {data}/>
</div>