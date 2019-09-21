<script>
  //  Canvas Guages 2.1.5
  // https://canvas-gauges.com
  import { beforeUpdate } from "svelte";
  export let data;
  let gauge;
  $: data = data;

  beforeUpdate(() => {
    if (
      data !== undefined &&
      document.getElementById("linear-gauge") !== null
    ) {
      if (gauge === undefined) {
        gauge = new LinearGauge({
          renderTo: "linear-gauge",
          value: data.value,
          width: 120,
          height: 400,
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
        });
        gauge.draw();
      }
      gauge.update({ value: data.value });
    }
  });
</script>

<style>
  canvas {
    padding: 0;
    margin: auto;
    display: block;
    width: 100%;
    height: 90%;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    transform: scale(0.9);
  }
</style>

<canvas id="linear-gauge" />
