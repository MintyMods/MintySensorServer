<script>
  // RoughViz Charts 1.0.4
  // https://github.com/jwilber/roughViz
  import { defaults } from "./defaults.js";
  import { attributes } from "../common/constants.js";
  import roughViz from "rough-viz";
  import { onDestroy, onMount, setContext } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import LineConfig from "./LineConfig.svelte";

  export let values;
  export let labels;
  let chart;
  let config;
  let chartPromiseResolve;
  let chartPromise = new Promise(resolve => (chartPromiseResolve = resolve));
  setContext("MSS:chart:Instance", getChartInstancePromise);
  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);

  $: chart;
  $: refreshChart(values, labels, defaults);

  onMount(() => {
    defaults.element = "#" + id;
    chart = new roughViz.Line(defaults);
    chartPromiseResolve(chart);
  });

  function getChartInstancePromise() {
    return chartPromise;
  }

  function refreshChart(values, labels, defaults) {
    if (chart !== undefined) {
      chart.data.labels = labels;
      chart.data.values = values;
      attributes.forEach(attr => {
        if (defaults[attr]) chart[attr] = defaults[attr];
      });
      chart.margin = defaults.margin;
      chart.svg.selectAll("*").remove();
      chart.drawChart();
    }
  }

  function resizeChart(node) {}

  export const showConfig = () => {
    config.openDialog();
  };

  export const hideConfig = () => {
    config.closeDialog();
  };

  function save(event) {
    let clone = event.detail;
    attributes.forEach(attr => {
      defaults[attr] = clone[attr];
    });
    document.getElementById(chart.el.substring(1)).innerHTML = "";
    chart = new roughViz.Line(defaults);
    // refreshChart(values, labels, defaults);
  }
</script>

<div {id} />

<LineConfig
  bind:this={config}
  {labels}
  {values}
  on:save={event => save(event)} />
