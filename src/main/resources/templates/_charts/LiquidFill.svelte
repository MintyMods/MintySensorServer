<script language="JavaScript">
  // Liquid Fill Gauge v1.1
  // https://gist.github.com/brattonc/5e5ce9beee483220e2f6
  import { beforeUpdate } from "svelte";
  import { Configurable } from "../_components/Configurable.svelte";

  export let data;
  let gauge;
  let id =
    "liquid-fill-" +
    Math.random()
      .toString(36)
      .replace(/[^a-z]+/g, "")
      .substr(2, 10);

beforeUpdate(() => {
    if (data !== undefined && document.getElementById(id) !== null) {
      if (gauge === undefined) {
        gauge = loadLiquidFillGauge(id, data, getConfig());
      }
      gauge.update(data);
    }
  });

  function getConfig() {
    let config = liquidFillGaugeDefaultSettings();
    config.minValue = 0;
    config.maxValue = 1600;
    config.circleThickness = 0.1;
    config.circleFillGap = 0.05;
    config.circleColor = "#6bb9f0";
    config.waveHeight = 0.05;
    config.waveCount = 3;
    config.waveRiseTime = 2000;
    config.waveAnimateTime = 1000;
    config.waveRise = true;
    config.waveHeightScaling = true;
    config.waveAnimate = true;
    config.waveColor = "#89c4f4";
    config.waveOffset = 0;
    config.textVertPosition = 0.52;
    config.textSize = 0.6;
    config.valueCountUp = true;
    config.displayPercent = false;
    config.textColor = "#3498db";
    config.waveTextColor = "#3498db";
    config.displayUnit = " rpm";
    return config;
  }
</script>

<style>
  svg {
    opacity: 0.5;
    width: 100%;
    height:100%;
    overflow: hidden;
  }
</style>

<svg {id} />
