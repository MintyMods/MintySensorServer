<script>
  // RoughViz Charts 1.0.4
  // https://github.com/jwilber/roughViz
  import { config } from "./defaults.js";
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
  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);

  $: refreshChart(values, labels);

  onMount(() => {
    config.element = "#" + id;
    chart = new roughViz.BarH(config);
  });

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

  function resizeChart(node) {
  }

  export const showConfig = item => {
    settings.openDialog(item);
  };

  export const hideConfig = () => {
    settings.closeDialog();
  };
</script>

 <div {id} />

<BarHorizontalConfig
  {labels}
  {values}
  {color}
  {width}
  {height}
  {circle}
  {circleRadius}
  {circleRoughness}
  {colorVar}
  {curbZero}
  {title}
  {axisFontSize}
  {axisRoughness}
  {axisStrokeWidth}
  {bowing}
  {fillStyle}
  {fillWeight}
  {fontFamily}
  {highlight}
  {innerStrokeWidth}
  {interactive}
  {labelFontSize}
  {top}
  {bottom}
  {right}
  {left}
  {padding}
  {roughness}
  {simplification}
  {stroke}
  {strokeWidth}
  {titleFontSize}
  {tooltipFontSize}
  {xLabel}
  {yLabel}
  {legend}
  {legendPosition}
  owner={id}
  {...config}
  bind:this={settings}
  on:color={event => (color = event.detail)}
  on:width={event => (width = event.detail)}
  on:height={event => (height = event.detail)}
  on:axisFontSize={event => (axisFontSize = event.detail)}
  on:axisRoughness={event => (axisRoughness = event.detail)}
  on:axisStrokeWidth={event => (axisStrokeWidth = event.detail)}
  on:bowing={event => (bowing = event.detail)}
  on:fillStyle={event => (fillStyle = event.detail)}
  on:fillWeight={event => (fillWeight = event.detail)}
  on:fontFamily={event => (fontFamily = event.detail)}
  on:highlight={event => (highlight = event.detail)}
  on:innerStrokeWidth={event => (innerStrokeWidth = event.detail)}
  on:interactive={event => (interactive = event.detail)}
  on:labelFontSize={event => (labelFontSize = event.detail)}
  on:top={event => (top = event.detail)}
  on:bottom={event => (bottom = event.detail)}
  on:left={event => (left = event.detail)}
  on:right={event => (right = event.detail)}
  on:padding={event => (padding = event.detail)}
  on:roughness={event => (roughness = event.detail)}
  on:simplification={event => (simplification = event.detail)}
  on:stroke={event => (stroke = event.detail)}
  on:strokeWidth={event => (strokeWidth = event.detail)}
  on:title={event => (title = event.detail)}
  on:titleFontSize={event => (titleFontSize = event.detail)}
  on:tooltipFontSize={event => (tooltipFontSize = event.detail)}
  on:xLabel={event => (xLabel = event.detail)}
  on:yLabel={event => (yLabel = event.detail)}
  on:legend={event => (legend = event.detail)}
  on:legendPosition={event => (legendPosition = event.detail)} />
