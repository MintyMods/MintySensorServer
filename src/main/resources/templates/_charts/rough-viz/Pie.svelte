<script>
  import Pie from "./Pie/Pie.svelte";
  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../../_stores/main-state.js";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  let title = "RoughViz Pie";
  let instance;
  let data;
  data = {
    labels: [],
    values: []
  };

  export const showConfig = gridItem => {
    instance.showConfig(gridItem);
  };

  beforeUpdate(() => {
    data.values = [];
    data.labels = [];
    let count = 0;
    if ($storeReadings.length > 0) {
      $storeReadings.forEach((reading, i) => {
        if (reading.type === 6 && count < 4) {
          count++;
          data.values.push(reading.value);
          data.labels.push(reading.label.desc);
        }
      });
    }
    data = data;
  });
</script>

<style>
  .chart {
    width: 100%;
    height: 100%;
  }

  .button-wrapper {
    position: absolute;
    top: 300px;
    left:100px;
    
  }
</style>

<div class="chart">
  <Pie
    bind:this={instance}
    values={data.values}
    labels={data.labels}
    {title} />
</div>

<div class="button-wrapper">
<Button  action="config" on:click={() => instance.showConfig()}>
  <Label>Show Config</Label>
</Button>
</div>
