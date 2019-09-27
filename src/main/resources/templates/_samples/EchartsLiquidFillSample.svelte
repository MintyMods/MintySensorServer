<script>
  import EchartsLiquidFill from "../_charts/echarts/EchartsLiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";
  export let edit;
  let data;
  let instance;
  $: data;

  export function showConfig() {
    instance.showConfig();
  }

  beforeUpdate(() => {
    if ($storeReadings.length > 0) {
      $storeReadings.forEach(function(reading, i) {
        if (reading.label.value === "HPWR Pump") {
          data = reading.value;
        }
        data = data;
      });
    }
  });

  //   if (edit !== undefined) {
  //       console.log("e1 " + edit);
  //       debugger
  // }
</script>

<EchartsLiquidFill bind:this={instance} {data} />
