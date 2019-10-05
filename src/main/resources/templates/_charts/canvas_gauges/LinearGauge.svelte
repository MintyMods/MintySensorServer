<script>
  //  Canvas Guages 2.1.5
  // https://canvas-gauges.com
  import { onMount, beforeUpdate } from "svelte";
  export let data;
  let gauge;
  let canvas;
  $: data = data;
  const id = "linear-gauge";

  export function showConfig() {
    PNotify.info("Linear Guage Config");
  }

  // onMount(() => {
  //   const wrapper = document.querySelector(".canvas-wrapper");
  //   let resize = new ResizeObserver(entries => {
  //     entries.forEach(entry => {
  //       if (canvas != null) {
  //          canvas.width = entry.contentRect.width;
  //          canvas.height = entry.contentRect.height;
  //         // gauge.options.width = entry.contentRect.width;
  //         // gauge.options.height = entry.contentRect.height;
  //         // gauge.update(getOptions());
  //         // gauge.setAttribute("data-width", entry.contentRect.width);
  //         // gauge.setAttribute("data-height", entry.contentRect.height);
  //       }
  //     });
  //   });

  //   resize.observe(wrapper);
  // });

  beforeUpdate(() => {
    if (data !== undefined && document.getElementById(id) !== null) {
      if (gauge === undefined) {
        gauge = new LinearGauge(getOptions());
        canvas = document.getElementById(id);
        gauge.draw();
      }
      gauge.update({ value: data.value });
    }
  });

  function getOptions() {
    return {
      renderTo: id,
      value: data.value,
      // width: null,
      // height: null,
      units: data.unit,
      title: data.label.desc,
      minValue: 0,
      maxValue: 120,
      majorTicks: ["0", "20", "40", "60", "80", "100", "120"],
      minorTicks: 2,
      strokeTicks: true,
      highlights: [
        {
          from: 90,
          to: 120,
          color: "rgba(200, 50, 50, .75)"
        }
      ],
      colorPlate: "rgba(255, 255, 255, .1)",
      borderShadowWidth: 0,
      borders: false,
      needleType: "arrow",
      needleWidth: 3,
      animationDuration: 1500,
      animationRule: "linear",
      tickSide: "left",
      numberSide: "left",
      needleSide: "left",
      needleCircleSize: 2,
      needleCircleOuter: true,
      needleCircleInner: false,
      barStrokeWidth: 1,
      barBeginCircle: false
    };
  }
</script>

<style>
  .canvas-wrapper {
    /* position: absolute; */
    width: 100%;
    height: auto;
    overflow: auto;
    min-width: 100px;
    min-height: 100px;
    display:inline-block;
  }
  canvas {
    padding: 0;
    margin: auto;
    display: inline-block;
    width: 100% !important;
    height: 100% !important;
    position: relative;
    max-width: 100%;
    max-height: 100%;
    /* top: 0;
    bottom: 0;
    left: 0;
    right: 0; */
    /* transform: scale(0.9); */
  }
</style>

<div class="canvas-wrapper">
  <canvas bind:this={canvas} {id} />
</div>
