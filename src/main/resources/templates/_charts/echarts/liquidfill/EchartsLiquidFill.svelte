<script>
  // Echarts Liquid Fill release 2.0.5
  // https://github.com/ecomfe/echarts-liquidfill
  import { onDestroy, onMount } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import EchartsLiquidFillConfig from "./EchartsLiquidFillConfig.svelte";
  import {
    color,
    center,
    radius,
    amplitude,
    waveLength,
    period,
    direction,
    shape,
    waveAnimation,
    animationEasing,
    animationEasingUpdate,
    animationDuration,
    animationDurationUpdate,
    outlineShow,
    outlineBorderDistance,
    outlineitemStyleColor,
    outlineitemStyleBorderColor,
    outlineitemStyleBorderWidth,
    outlineitemStyleShadowBlur,
    outlineitemStyleShadowColor,
    backgroundStyleColor,
    backgroundStyleBorderWidth,
    backgroundStyleBorderColor,
    backgroundStyleItemStyleShadowBlur,
    backgroundStyleItemStyleShadowColor,
    backgroundStyleItemStyleOpacity,
    itemStyleOpacity,
    itemStyleShadowBlur,
    itemStyleShadowColor,
    emphasisItemStyleOpacity,
    labelShow,
    labelColor,
    labelInsideColor,
    labelFontSize,
    labelFontWeight,
    labelAlign,
    labelBaseline,
    labelPosition
  } from "./config/echarts-liquid-fill-store.js";
  export let data;
  export let options;
  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);
  let chart;
  let config;

  $: refreshChart(data);

  onMount(() => {
    chart = echarts.init(document.getElementById(id));
  });

  onDestroy(() => {
    chart.dispose();
  });

  function refreshChart(data) {
    if (data !== undefined) {
      if (chart !== undefined) {
        chart.setOption(getOptions());
      }
    }
  }

  function resizeChart(node) {
    const canvas = getCanvas();
    if (canvas !== null) {
      canvas.width = node.clientWidth;
      canvas.height = node.clientheight;
      chart.resize();
    }
  }

  export const getCanvas = () => {
    return document
      .getElementById(id)
      .querySelectorAll("canvas")
      .item(0);
  };

  export const showConfig = item => {
    config.openDialog(item);
  };

  export const hideConfig = () => {
    config.closeDialog();
  };

  function getOptions() {
    return {
      series: [
        {
          type: "liquidFill",
          data: [data.value],
          options: {
            responsive: false
          },
          silent: true,
          phase: "auto",
          shape: $shape,
          direction: $direction,
          amplitude: $amplitude,
          waveAnimation: $waveAnimation,
          animationEasing: $animationEasing,
          animationEasingUpdate: $animationEasingUpdate,
          animationDuration: $animationDuration,
          animationDurationUpdate: $animationDurationUpdate,
          color: $color,
          center: $center,
          radius: $radius,
          waveLength: $waveLength,
          period: $period,
          outline: {
            show: $outlineShow,
            borderDistance: $outlineBorderDistance,
            itemStyle: {
              color: $outlineitemStyleColor,
              borderColor: $outlineitemStyleBorderColor,
              borderWidth: $outlineitemStyleBorderWidth,
              shadowBlur: $outlineitemStyleShadowBlur,
              shadowColor: $outlineitemStyleShadowColor
            }
          },
          backgroundStyle: {
            color: $backgroundStyleColor,
            borderWidth: $backgroundStyleBorderWidth,
            borderColor: $backgroundStyleBorderColor,
            shadowBlur: $backgroundStyleItemStyleShadowBlur,
            shadowColor: $backgroundStyleItemStyleShadowColor,
            opacity: $backgroundStyleItemStyleOpacity
          },
          itemStyle: {
            opacity: $itemStyleOpacity,
            shadowBlur: $itemStyleShadowBlur,
            shadowColor: $itemStyleShadowColor
          },
          label: {
            formatter: '{c} ' + data.unit,
            show: $labelShow,
            color: $labelColor,
            insideColor: $labelInsideColor,
            fontSize: $labelFontSize,
            fontWeight: $labelFontWeight,
            align: $labelAlign,
            baseline: $labelBaseline,
            position: $labelPosition
          },
          emphasis: {
            itemStyle: {
              opacity: $emphasisItemStyleOpacity
            }
          }
        }
      ]
    };
  }
</script>

<style>
  .gauge {
    display: block;
    width: 100%;
    height: 100%;
    transform: scale(1.7);
  }
</style>

<div {id} class="gauge" use:watchResize={resizeChart} />

<EchartsLiquidFillConfig bind:this={config} {data} {chart} />
