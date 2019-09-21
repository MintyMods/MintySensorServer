<script>
  
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart.svelte";
  import TempsBarChart from "../_samples/TempsBarChart.svelte";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill.svelte";
  import PowerLineChart from "../_samples/PowerLineChart.svelte";
  import JustGageSample from "../_samples/JustGageSample.svelte";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample.svelte";
  import Notification from "../_components/Notification.svelte";

  import { beforeUpdate } from "svelte";
  import { storeReadings } from "../_stores/main-state.js";

  // let data;
  // let labels = [];
  //
  // beforeUpdate(() => {
  // if ($storeReadings.length > 1) {
  // data = [];
  // labels = [];
  // $storeReadings.forEach(function(reading, i) {
  // if (i > 10 && i < 15) { // data.push(reading.value); // labels.push(reading.label.description); // } // }); // } // });
</script>

<style>
  .container {
    position: relative;
    display: flex;
    flex-direction: column;
  }

  .chart {
    position: relative;
    display: inline-flex;
    width: 98%;
    height: 480px;
    border: 1px solid black;
    padding: 10px;
  }
</style>

<svelte:head>
  <title>Home</title>
</svelte:head>
<div class="container">
  <div class="chart">
    <EchartsLiquidFillSample />
    <WaterTempLiquidFill />
  </div>
  <div class="chart">
    <JustGageSample />
  </div>
  <div class="chart">
    <ClockSpeedsBarChart />
  </div>
  <div class="chart">
    <PowerLineChart />
  </div>
  <div class="chart">
    <TempsBarChart />
  </div>
</div>

<!--
<Notification type="notice" text="notice message" title="Notice Message" />
<Notification type="info" text="info message" title="Info Message" />
<Notification type="warning" text="warning message" title="Warning Message" />
<Notification type="error" text="error message" title="Error Message" />
-->
<Notification type="success" text="success message" title="Success Message" />
