<script>
  // Echarts Liquid Fill release 2.0.5
  // https://github.com/ecomfe/echarts-liquidfill
  import { SHAPES } from "./config/constants.js";
  import { onDestroy, onMount } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import EchartsLiquidFillConfig from "./EchartsLiquidFillConfig.svelte";

  export let color = "rgba(0, 0, 0, 1)";
  export let center = ["50%", "50%"];
  export let radius = "99%";
  export let amplitude = "58%";
  export let waveLength = "400%";
  export let period = "auto";
  export let direction = "right";
  export let shape = "batman";
  export let waveAnimation = true;
  export let animationEasing = "linear";
  export let animationEasingUpdate = "linear";
  export let animationDuration = 2000;
  export let animationDurationUpdate = 1000;
  export let outlineShow = true;
  export let outlineBorderDistance = 1;
  export let outlineitemStyleColor = "#000";
  export let outlineitemStyleBorderColor = "#000";
  export let outlineitemStyleBorderWidth = 8;
  export let outlineitemStyleShadowBlur = 9;
  export let outlineitemStyleShadowColor = "rgba(0, 0, 0, 0.5)";
  export let backgroundStyleColor = "rgba(250.16, 252.02, 6.07, 1)";
  export let backgroundStyleBorderWidth = 4;
  export let backgroundStyleBorderColor = "#000";
  export let backgroundStyleItemStyleShadowBlur = 10;
  export let backgroundStyleItemStyleShadowColor =
    "rgba(177.78, 169.57, 169.57, 1)";
  export let backgroundStyleItemStyleOpacity = 0.9;
  export let itemStyleOpacity = 0.95;
  export let itemStyleShadowBlur = 50;
  export let itemStyleShadowColor = "rgba(0, 0, 0, 0.4)";
  export let emphasisItemStyleOpacity = 0.8;
  export let labelShow = true;
  export let labelColor = "#000";
  export let labelInsideColor = "#fff";
  export let labelFontSize = 50;
  export let labelFontWeight = "normal";
  export let labelAlign = "center";
  export let labelBaseline = "middle";
  export let labelPosition = "inside";
  export let divide = 10000;
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
    if (data !== undefined && chart !== undefined) {
      chart.setOption(getOptions());
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

  function getShape() {
    let path;
    SHAPES.forEach(item => {
      if (item.type === shape) {
        path = item.path ? item.path : item.type;
      }
    });
    return path;
  }

  function formatData(data) {
    // console.log(data);
    let out = data;
    if (data > 0 && data < 10) {
      out = data / 10;
    } else if (data > 10 && data < 100) {
      out = data / 100;
    } else if (data > 100 && data < 1000) {
      out = data / 1000;
    } else if (data > 1000 && data < 10000) {
      out = data / 1000;
    } else if (data > 10000 && data < 100000) {
      out = data / 10000;
    }
    return out;
  }

  function getOptions() {
    return {
      series: [
        {
          type: "liquidFill",
          data: [formatData(data.value), 0.06, 0.03, 0.05],
          options: {
            responsive: false
          },
          silent: true,
          phase: "auto",
          color: ["yellow"],
          shape: getShape(),
          direction,
          amplitude,
          waveAnimation,
          animationEasing,
          animationEasingUpdate,
          animationDuration,
          animationDurationUpdate,
          center,
          radius,
          waveLength,
          period,
          outline: {
            show: outlineShow,
            borderDistance: outlineBorderDistance,
            itemStyle: {
              color: outlineitemStyleColor,
              borderColor: outlineitemStyleBorderColor,
              borderWidth: outlineitemStyleBorderWidth,
              shadowBlur: outlineitemStyleShadowBlur,
              shadowColor: outlineitemStyleShadowColor
            }
          },
          backgroundStyle: {
            color: backgroundStyleColor,
            borderWidth: backgroundStyleBorderWidth,
            borderColor: backgroundStyleBorderColor,
            shadowBlur: backgroundStyleItemStyleShadowBlur,
            shadowColor: backgroundStyleItemStyleShadowColor,
            opacity: backgroundStyleItemStyleOpacity
          },
          itemStyle: {
            opacity: itemStyleOpacity,
            shadowBlur: itemStyleShadowBlur,
            shadowColor: itemStyleShadowColor
          },
          label: {
            formatter: "{c} " + data.unit,
            show: labelShow,
            color: labelColor,
            insideColor: labelInsideColor,
            fontSize: labelFontSize,
            fontWeight: labelFontWeight,
            align: labelAlign,
            baseline: labelBaseline,
            position: labelPosition
          },
          emphasis: {
            itemStyle: {
              opacity: emphasisItemStyleOpacity
            }
          }
        }
      ]
    };
  }
</script>

<style>
  .gauge {
    display: inline-block;
    min-width: 500px;
    min-height: 300px;
    /* width: 100%;
    height: 100%;
    width: 400px;  */
    /* height: 300px; */
  }
</style>

<div {id} class="gauge" use:watchResize={resizeChart} />
