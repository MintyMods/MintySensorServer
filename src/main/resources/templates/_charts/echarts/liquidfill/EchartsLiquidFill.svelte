<script>
  // Echarts Liquid Fill release 2.0.5
  // https://github.com/ecomfe/echarts-liquidfill
  import { SHAPES } from "./config/constants.js";
  import { onDestroy, onMount } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import EchartsLiquidFillConfig from "./EchartsLiquidFillConfig.svelte";

  export let color = "rgba(0, 0, 0, 1)";
  export let center = ["50%", "50%"];
  export let radius = "150%";
  export let amplitude = "58%";
  export let waveLength = "400%";
  export let period = "auto";
  export let direction = "right";
  export let shape = "batman";
  export let waveAnimation = true;
  export let animationEasing = "linear";
  export let animationEasingUpdate = "linear";
  export let animationDuration = 1000;
  export let animationDurationUpdate = 1000;
  export let outlineShow = true;
  export let outlineBorderDistance = 1;
  export let outlineitemStyleColor = "#000";
  export let outlineitemStyleBorderColor = "#000";
  export let outlineitemStyleBorderWidth = 6;
  export let outlineitemStyleShadowBlur = 9;
  export let outlineitemStyleShadowColor = "rgba(0, 0, 0, 0.5)";
  export let backgroundStyleColor = "rgba(250.16, 252.02, 6.07, 1)";
  export let backgroundStyleBorderWidth = 4;
  export let backgroundStyleBorderColor = "#000";
  export let backgroundStyleItemStyleShadowBlur = 10;
  export let backgroundStyleItemStyleShadowColor = "rgba(0, 0, 0, 1)";
  export let backgroundStyleItemStyleOpacity = 0.9;
  export let itemStyleOpacity = 0.95;
  export let itemStyleShadowBlur = 25;
  export let itemStyleShadowColor = "rgba(0, 0, 0, 0.4)";
  export let emphasisItemStyleOpacity = 0.8;
  export let labelShow = true;
  export let labelColor = "#000";
  export let labelInsideColor = "#fff";
  export let labelFontSize = 30;
  export let labelFontWeight = "normal";
  export let labelAlign = "center";
  export let labelBaseline = "middle";
  export let labelPosition = "inside";
  export let data;

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

  export const showConfig = item => {
    console.log("showing config in fill");
    config.openDialog(item);
  };

  export const hideConfig = () => {
    config.closeDialog();
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
    width: 100%;
    height: 100%;
  }
</style>

<div {id} class="gauge" use:watchResize={resizeChart} />

<EchartsLiquidFillConfig
  owner={id}
  {data}
  {shape}
  {color}
  {center}
  {radius}
  {amplitude}
  {waveLength}
  {period}
  {direction}
  {waveAnimation}
  {animationEasing}
  {animationEasingUpdate}
  {animationDuration}
  {animationDurationUpdate}
  {outlineShow}
  {outlineBorderDistance}
  {outlineitemStyleColor}
  {outlineitemStyleBorderColor}
  {outlineitemStyleBorderWidth}
  {outlineitemStyleShadowBlur}
  {outlineitemStyleShadowColor}
  {backgroundStyleColor}
  {backgroundStyleBorderWidth}
  {backgroundStyleBorderColor}
  {backgroundStyleItemStyleShadowBlur}
  {backgroundStyleItemStyleShadowColor}
  {backgroundStyleItemStyleOpacity}
  {itemStyleOpacity}
  {itemStyleShadowBlur}
  {itemStyleShadowColor}
  {emphasisItemStyleOpacity}
  {labelShow}
  {labelColor}
  {labelInsideColor}
  {labelFontSize}
  {labelFontWeight}
  {labelAlign}
  {labelBaseline}
  {labelPosition}
  bind:this={config}
  on:shape={event => (shape = event.detail)}
  on:color={event => (color = event.detail)}
  on:center={event => (center = event.detail)}
  on:radius={event => (radius = event.detail)}
  on:amplitude={event => (amplitude = event.detail)}
  on:waveLength={event => (waveLength = event.detail)}
  on:period={event => (period = event.detail)}
  on:direction={event => (direction = event.detail)}
  on:waveAnimation={event => (waveAnimation = event.detail)}
  on:animationEasing={event => (animationEasing = event.detail)}
  on:animationEasingUpdate={event => (animationEasingUpdate = event.detail)}
  on:animationDuration={event => (animationDuration = event.detail)}
  on:animationDurationUpdate={event => (animationDurationUpdate = event.detail)}
  on:outlineShow={event => (outlineShow = event.detail)}
  on:outlineBorderDistance={event => (outlineBorderDistance = event.detail)}
  on:outlineitemStyleColor={event => (outlineitemStyleColor = event.detail)}
  on:outlineitemStyleBorderColor={event => (outlineitemStyleBorderColor = event.detail)}
  on:outlineitemStyleBorderWidth={event => (outlineitemStyleBorderWidth = event.detail)}
  on:outlineitemStyleShadowBlur={event => (outlineitemStyleShadowBlur = event.detail)}
  on:outlineitemStyleShadowColor={event => (outlineitemStyleShadowColor = event.detail)}
  on:backgroundStyleColor={event => (backgroundStyleColor = event.detail)}
  on:backgroundStyleBorderWidth={event => (backgroundStyleBorderWidth = event.detail)}
  on:backgroundStyleBorderColor={event => (backgroundStyleBorderColor = event.detail)}
  on:backgroundStyleItemStyleShadowBlur={event => (backgroundStyleItemStyleShadowBlur = event.detail)}
  on:backgroundStyleItemStyleShadowColor={event => (backgroundStyleItemStyleShadowColor = event.detail)}
  on:backgroundStyleItemStyleOpacity={event => (backgroundStyleItemStyleOpacity = event.detail)}
  on:itemStyleOpacity={event => (itemStyleOpacity = event.detail)}
  on:itemStyleShadowBlur={event => (itemStyleShadowBlur = event.detail)}
  on:itemStyleShadowColor={event => (itemStyleShadowColor = event.detail)}
  on:emphasisItemStyleOpacity={event => (emphasisItemStyleOpacity = event.detail)}
  on:labelShow={event => (labelShow = event.detail)}
  on:labelColor={event => (labelColor = event.detail)}
  on:labelInsideColor={event => (labelInsideColor = event.detail)}
  on:labelFontSize={event => (labelFontSize = event.detail)}
  on:labelFontWeight={event => (labelFontWeight = event.detail)}
  on:labelAlign={event => (labelAlign = event.detail)}
  on:labelBaseline={event => (labelBaseline = event.detail)}
  on:labelPosition={event => (labelPosition = event.detail)} />
