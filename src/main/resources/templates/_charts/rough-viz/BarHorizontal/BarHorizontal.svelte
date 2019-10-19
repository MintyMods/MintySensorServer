<script>
  // RoughViz Charts 1.0.4
  // https://github.com/jwilber/roughViz
  import roughViz from "rough-viz";
  import { FILL_STYLE, FONT_FAMILY } from "./config/constants.js";
  import { onDestroy, onMount } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import BarHorizontalConfig from "./BarHorizontalConfig.svelte";

  export let title;
  export let values;
  export let labels;
  export let config;
  let chart;
  let settings;
  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);

  $: refreshChart(values, labels);

  onMount(() => {
    chart = new roughViz.BarH(getDefaultOptions());
  });

  function refreshChart(values, labels) {
    if (chart !== undefined) {
      chart.data.labels = labels;
      chart.data.values = values;
      chart.svg.selectAll("*").remove();
      chart.drawChart();
    }
  }

  function resizeChart(node) {
    // const canvas = getCanvas();
    // if (canvas !== null) {
    //   canvas.width = node.clientWidth;
    //   canvas.height = node.clientheight;
    //   chart.resize();
    // }
  }

  export const showConfig = item => {
    settings.openDialog(item);
  };

  export const hideConfig = () => {
    settings.closeDialog();
  };

  function getDefaultOptions() {
    config = {
      element: "#" + id,
      data: {
        labels: [],
        values: []
      },
      color: "f51d9b",
      title: "CPU Clock Speeds",
      // color:['red', 'orange', 'blue', 'skyblue'],
      axisFontSize: "1rem",
      axisRoughness: 0.5,
      axisStrokeWidth: 0.5,
      bowing: 0,
      fillStyle: FILL_STYLE.CROSS_HATCH.id,
      fillWeight: 0.2,
      font: FONT_FAMILY.INDIE_FLOWER.id,
      highlight: "coral",
      innerStrokeWidth: 1,
      interactive: true,
      labelFontSize: "2rem",
      margin: { top: 50, bottom: 100, left: 160, right: 0 },
      padding: 0.2,
      roughness: 4,
      simplification: 0.1,
      stroke: "#bd006d",
      strokeWidth: 2,
      titleFontSize: "2rem",
      tooltipFontSize: "1rem",
      xLabel: "",
      yLabel: "Mhz",
      legend: true
    };
    return config;
  }
</script>

<style>
  .wrapper {
    display: flex;
    flex: wrap;
    order: row;
  }
</style>

<div class="wrapper">
  <div {id} />
</div>

<BarHorizontalConfig
  {labels}
  {values}
  owner={id}
  {...config}
  bind:this={settings}
  on:color={event => (config.color = event.detail)}
  on:axisFontSize={event => (config.axisFontSize = event.detail)}
  on:axisRoughness={event => (config.axisRoughness = event.detail)}
  on:axisStrokeWidth={event => (config.axisStrokeWidth = event.detail)}
  on:bowing={event => (config.bowing = event.detail)}
  on:fillStyle={event => (config.fillStyle = event.detail)}
  on:fillWeight={event => (config.fillWeight = event.detail)}
  on:font={event => (config.font = event.detail)}
  on:highlight={event => (config.highlight = event.detail)}
  on:innerStrokeWidth={event => (config.innerStrokeWidth = event.detail)}
  on:interactive={event => (config.interactive = event.detail)}
  on:labelFontSize={event => (config.labelFontSize = event.detail)}
  on:margin={event => (config.margin = event.detail)}
  on:padding={event => (config.padding = event.detail)}
  on:roughness={event => (config.roughness = event.detail)}
  on:simplification={event => (config.simplification = event.detail)}
  on:stroke={event => (config.stroke = event.detail)}
  on:strokeWidth={event => (config.strokeWidth = event.detail)}
  on:title={event => (config.title = event.detail)}
  on:titleFontSize={event => (config.titleFontSize = event.detail)}
  on:tooltipFontSize={event => (config.tooltipFontSize = event.detail)}
  on:xLabel={event => (config.xLabel = event.detail)}
  on:yLabel={event => (config.yLabel = event.detail)}
  on:legend={event => (config.legend = event.detail)} />
