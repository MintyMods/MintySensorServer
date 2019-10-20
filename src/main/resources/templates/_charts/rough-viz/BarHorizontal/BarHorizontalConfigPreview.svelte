<script>
  // RoughViz Charts 1.0.4
  // https://github.com/jwilber/roughViz
  import { config } from "./defaults.js";
  import panzoom from "panzoom";
  import roughViz from "rough-viz";
  import { onDestroy, onMount } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import BarHorizontalConfig from "./BarHorizontalConfig.svelte";

  export let title;
  export let color;
  export let values;
  export let labels;
  export let width;
  export let height;
  export let circle;
  export let circleRadius;
  export let circleRoughness;
  export let colorVar;
  export let curbZero;
  export let axisFontSize;
  export let axisRoughness;
  export let axisStrokeWidth;
  export let bowing;
  export let fillStyle;
  export let fillWeight;
  export let fontFamily;
  export let highlight;
  export let innerStrokeWidth;
  export let interactive;
  export let labelFontSize;
  export let left;
  export let bottom;
  export let top;
  export let right;
  export let padding;
  export let roughness;
  export let simplification;
  export let stroke;
  export let strokeWidth;
  export let titleFontSize;
  export let tooltipFontSize;
  export let xLabel;
  export let yLabel;
  export let legend;
  export let legendPosition;

  let chart;
  let settings;

  const PREVIEW_X = 0.5;
  const PREVIEW_Y = 0.5;
  const PREVIEW_ZOOM = .5;
  const PREVIEW_MAX_ZOOM = 1;
  const PREVIEW_MIN_ZOOM = 0.1;

  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);

  onMount(() => {
    config.element = "#" + id;
    chart = new roughViz.BarH(config);
    initPreview();
  });

  $: refreshChart(values, labels);

  function initPreview() {
    let preview = document.getElementById(id);
    panzoom(preview, {
      maxZoom: PREVIEW_MAX_ZOOM,
      minZoom: PREVIEW_MIN_ZOOM
    }).zoomAbs(PREVIEW_X, PREVIEW_Y, PREVIEW_ZOOM);
  }

  function refreshChart(values, labels) {
    if (chart !== undefined) {
      chart.data.labels = labels;
      chart.data.values = values;
      chart.color = color || config.color;
      chart.width = width || config.width;
      chart.height = height || config.height;
      chart.circle = circle || config.circle;
      chart.circleRadius = circleRadius || config.circleRadius;
      chart.circleRoughness = circleRoughness || config.circleRoughness;
      chart.colorVar = colorVar || config.colorVar;
      chart.curbZero = curbZero || config.curbZero;
      chart.color = color || config.color;
      chart.title = title || config.title;
      chart.axisFontSize = axisFontSize || config.axisFontSize;
      chart.axisRoughness = axisRoughness || config.axisRoughness;
      chart.axisStrokeWidth = axisStrokeWidth || config.axisStrokeWidth;
      chart.bowing = bowing || config.bowing;
      chart.fillStyle = fillStyle || config.fillStyle;
      chart.fillWeight = fillWeight || config.fillWeight;
      chart.fontFamily = fontFamily || config.fontFamily;
      chart.highlight = highlight || config.highlight;
      chart.innerStrokeWidth = innerStrokeWidth || config.innerStrokeWidth;
      chart.interactive = interactive || config.interactive;
      chart.labelFontSize = labelFontSize || config.labelFontSize;
      chart.margin = {
        top: top || config.top,
        bottom: bottom || config.bottom,
        right: right || config.right,
        left: left || config.left
      };
      chart.padding = padding || config.padding;
      chart.roughness = roughness || config.roughness;
      chart.simplification = simplification || config.simplification;
      chart.stroke = stroke || config.stroke;
      chart.strokeWidth = strokeWidth || config.strokeWidth;
      chart.titleFontSize = titleFontSize || config.titleFontSize;
      chart.tooltipFontSize = tooltipFontSize || config.tooltipFontSize;
      chart.xLabel = xLabel || config.xLabel;
      chart.yLabel = yLabel || config.yLabel;
      chart.legend = legend || config.legend;
      chart.legendPosition = legendPosition || config.legendPosition;
      chart.svg.selectAll("*").remove();
      chart.drawChart();
    }
  }
</script>

<div {id} />
