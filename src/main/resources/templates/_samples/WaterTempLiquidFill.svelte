<script>
  import LiquidFill from "../_charts/LiquidFill.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  export let data;
  export let edit;
  $: edit;
  $: data;
  export function open(...args) {
    console.log("open");
    
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

    console.log("***************** e2 " + edit);

</script>

<LiquidFill {data} bind:edit={edit} />

