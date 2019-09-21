<script>
  import EchartsLiquidFill from "../_charts/echarts/EchartsLiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  let data;
  $: data;
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
</script>

<EchartsLiquidFill {data} />
