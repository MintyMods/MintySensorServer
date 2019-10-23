<script>

  import { ATTRIBUTES, PREVIEW } from "./defaults.js";
  import panzoom from "panzoom";
  import roughViz from "rough-viz";
  import { onDestroy, onMount, getContext } from "svelte";
  import BarHorizontalConfig from "./BarHorizontalConfig.svelte";

  export let labels;
  export let values;

  let getInstance = getContext("MSS:chart:getInstance");
  let id = "preview";
  let config;
  let chart;

  onMount(async () => {
    config = await getInstance();
    chart = new roughViz.BarH({
      element: "#" + id,
      data: { labels: [], values: [] }
    });
    initPreview();
    refreshChart();
  });

  $: refreshChart(config, values, labels);

  function initPreview() {
    panzoom(document.getElementById(id), {
      maxZoom: PREVIEW.maxZoom,
      minZoom: PREVIEW.minZoom,
      zoomSpeed: PREVIEW.zoomSpeed
    }).zoomAbs(PREVIEW.x, PREVIEW.y, PREVIEW.zoom);
  }

  function refreshChart(config) {
    if ((chart !== undefined && config !== undefined)) {
      ATTRIBUTES.forEach(attr => {
        chart[attr] = config[attr];
      });
      chart.data.values = values;
      chart.data.labels = labels;
      chart.svg.selectAll("*").remove();
      chart.drawChart();
    }
  }

</script>

<div {id} />
