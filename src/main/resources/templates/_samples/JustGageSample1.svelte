<script>
  import JustGage from "../_charts/JustGage.svelte";
  import { storeReadings, storeTypes } from "../_stores/main-state.js";

  let caption = "GPU Temperature";
  let data;
  let instance;
  $: data = data;

  export function showConfig() {
    instance.showConfig();
  }

  $: if ($storeReadings.length > 0) {
    $storeReadings.forEach(function(reading, i) {
      if (
        $storeTypes[reading.type].name == "TEMP" &&
        reading.label.desc.includes("GPU Temperature")
      ) {
        data = reading;
      }
    });
  }
</script>

{#if data}
  <JustGage bind:this={instance} {data} />
{/if}
