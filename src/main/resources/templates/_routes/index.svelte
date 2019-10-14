<script>
  import Notification from "../_components/Notification.svelte";
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart.svelte";
  import TempsBarChart from "../_samples/TempsBarChart.svelte";
  import PowerLineChart from "../_samples/PowerLineChart.svelte";
  import JustGageSample2 from "../_samples/JustGageSample2.svelte";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample.svelte";

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
  </div>
  <div class="chart">
    <JustGageSample2 />
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

<Notification type="success" text="Example notification message" title="Great Success!" />
