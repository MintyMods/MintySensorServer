<script>
  //   import "../_scss/_views.scss";

  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart";
  import JustGageSample2 from "../_samples/JustGageSample2";
  import TempsBarChart from "../_samples/TempsBarChart";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill";
  import PowerLineChart from "../_samples/PowerLineChart";
  import JustGageSample1 from "../_samples/JustGageSample1";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample";
  import LinearGaugeSample from "../_samples/LinearGaugeSample";
  import JustGageSample3 from "../_samples/JustGageSample3";
  import RadialGaugeSample from "../_samples/RadialGaugeSample";

  import { onMount, tick } from "svelte";
  import ChartCard from "../_components/ChartCard";

  onMount(async () => {
    await tick();
    buildCharts();
  });

  let charts = [
    WaterTempLiquidFill,
    EchartsLiquidFillSample,
    JustGageSample2,
    ClockSpeedsBarChart,
    TempsBarChart,
    JustGageSample1,
    PowerLineChart,
    LinearGaugeSample,
    JustGageSample3,
    RadialGaugeSample
  ];
  let ratios = [
    "square",
    "16x9",
    "16x9",
    "16x9",
    "16x9",
    "square",
    "square",
    "square",
    "square",
    "square"
  ];
  let clicked;
  let config;
  let pckry;
  $: config;

  function buildCharts() {
    temps = new TempsBarChart({ target: document.getElementById("test") });
    console.log(temps);
  }

  function getChart(type, target) {
    switch (type) {
      case "WaterTempLiquidFill":
        let chart = new ChartCard({ target: target, thing: 'thing' });
        let ele = document.getElementById('thing');
        debugger
        return new WaterTempLiquidFill({
          target: ele
        });
      case "EchartsLiquidFillSample":
        return new EchartsLiquidFillSample({ target: target });
      case "JustGageSample2":
        return new JustGageSample2({ target: target });
      case "ClockSpeedsBarChart":
        return new ClockSpeedsBarChart({ target: target });
      case "TempsBarChart":
        return new TempsBarChart({ target: target });
      case "JustGageSample1":
        return new JustGageSample1({ target: target });
      case "PowerLineChart":
        return new PowerLineChart({ target: target });
      case "LinearGaugeSample":
        return new LinearGaugeSample({ target: target });
      case "JustGageSample3":
        return new JustGageSample3({ target: target });
      case "RadialGaugeSample":
        return new RadialGaugeSample({ target: target });
    }
  }
</script>

<br />
<br />
<br />
<br />

<ChartCard>
  <div id="test" />
</ChartCard>
<button
  on:click={() => getChart('WaterTempLiquidFill', document.getElementById('test'))}>
  Click
</button>

<!-- {#each charts as chart}
  <ChartCard>
    <svelte:component this={chart} />
  </ChartCard>
{/each} -->
