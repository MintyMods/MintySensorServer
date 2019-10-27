<script>
  import { preview } from "./defaults.js";
  import { attributes } from "../common/constants.js";
  import panzoom from "panzoom";
  import roughViz from "rough-viz";
  import { onDestroy, onMount, getContext } from "svelte";
  import PieConfig from "./PieConfig.svelte";

  export let labels;
  export let values;

  let getInstance = getContext("MSS:chart:Preview");
  let id = "preview";
  let config;
  let chart;

  onMount(async () => {
    config = await getInstance();
    chart = new roughViz.Pie({
      element: "#" + id,
      data: { labels: [], values: [] }
    });
    refreshChart();
    initPreview();
  });

  function initPreview() {
    panzoom(document.getElementById(id), {
      maxZoom: preview.maxZoom,
      minZoom: preview.minZoom,
      zoomSpeed: preview.zoomSpeed
    }).zoomAbs(preview.x, preview.y, preview.zoom);
  }

  function refreshChart(config) {
    if (chart !== undefined && config !== undefined) {
      attributes.forEach(attr => {
        chart[attr] = config[attr];
      });
      chart.data.labels = labels;
      chart.data.values = values;
      chart.svg.selectAll("*").remove();
      chart.drawChart();
    }
  }

  $: refreshChart(config, values, labels);
</script>

<div {id} />
