<script>
  import { beforeUpdate } from "svelte";
  export let data;
  let gauge;
  $: data = data;
  beforeUpdate(() => {
    if (
      data !== undefined &&
      document.getElementById("radial-gauge") !== null
    ) {
      if (gauge === undefined) {
        gauge = new RadialGauge({
          renderTo: "radial-gauge",
          value: data.value,
          title: data.label.desc,
          units: data.unit,
          minValue: data.min,
          maxValue: data.max,
            width:300,
            height:300,
          minorTicks: 2,
          strokeTicks: true,
          highlights: [
            {
              from: data.max - 1000,
              to: data.max,
              color: "rgba(200, 50, 50, .75)"
            }
          ],
          colorPlate: "rgba(255, 255, 255, .1)",
          borderShadowWidth: 0,
          borders: false,
          needleType: "arrow",
          needleWidth: 2,
          needleCircleSize: 7,
          needleCircleOuter: true,
          needleCircleInner: false,
          animationDuration: 1500,
          animationRule: "radial"
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
    height: 100%;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
}
</style>

<canvas id="radial-gauge" />
