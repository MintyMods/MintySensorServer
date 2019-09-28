<script language="JavaScript">
  // Liquid Fill Gauge v1.1
  // https://gist.github.com/brattonc/5e5ce9beee483220e2f6
  import { onMount, beforeUpdate, tick } from "svelte";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Button, { Label } from "@smui/button";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  export let data;
  export let minValue = 0;
  export let maxValue = 1800;
  export let circleThickness = 0.1;
  export let circleFillGap = 0.05;
  export let circleColor = "#6bb9f0";
  export let waveHeight = 0.05;
  export let waveCount = 3;
  export let waveRiseTime = 2000;
  export let waveAnimateTime = 1000;
  export let waveRise = true;
  export let waveHeightScaling = true;
  export let waveAnimate = true;
  export let waveColor = "#89c4f4";
  export let waveOffset = 0;
  export let textVertPosition = 0.52;
  export let textSize = 0.6;
  export let valueCountUp = true;
  export let displayPercent = false;
  export let textColor = "#3498db";
  export let waveTextColor = "#3498db";
  // config.displayUnit = " " + data.unit;

  let dialog;
  let gauge;
  let config;
  $: config = config;

  let id =
    "liquid-fill-" +
    Math.random()
      .toString(36)
      .replace(/[^a-z]+/g, "")
      .substr(2, 10);

  onMount(async () => {
    await tick();
    config = getConfig();
  });

  beforeUpdate(() => {
    if (data !== undefined && document.getElementById(id) !== null) {
      if (gauge === undefined) {
        gauge = loadLiquidFillGauge(id, data, config);
      }
      gauge.update(data.value, config);
    }
  });

  export function showConfig() {
    //alert("Liquid Fill Config");
    dialog.open();
  }

  function selectionCloseHandler() {
    return false;
  }

  $: minValue;
  $: waveCount;

  function getConfig() {
    config = liquidFillGaugeDefaultSettings();
    config.minValue = minValue;
    config.maxValue = maxValue;
    config.circleThickness = circleThickness;
    config.circleFillGap = circleFillGap;
    config.circleColor = circleColor;
    config.waveHeight = waveHeight;
    config.waveCount = waveCount;
    config.waveRiseTime = waveRiseTime;
    config.waveAnimateTime = waveAnimateTime;
    config.waveRise = waveRise;
    config.waveHeightScaling = waveHeightScaling;
    config.waveAnimate = waveAnimate;
    config.waveColor = waveColor;
    config.waveOffset = waveOffset;
    config.textVertPosition = textVertPosition;
    config.textSize = textSize;
    config.valueCountUp = valueCountUp;
    config.displayPercent = displayPercent;
    config.textColor = textColor;
    config.waveTextColor = waveTextColor;
    // config.displayUnit = " " + data.unit;
    return config;
  }

  // export function open(...args) {
  //   return dialog.open(...args);
  // }
  let value;

  // on:MDCDialog:closed={selectionCloseHandler}
  // scrimClickAction={() => alert()}
</script>

<style>
  svg {
    opacity: 0.5;
    width: 98%;
    height: 98%;
    overflow: hidden;
    /* transform: scale(0.8); */
  }

  #config {
    position: fixed;
    top: 10px;
    right: 0px;
    border: 2px dashed red;
    width: 600px;
  }
</style>

<svg {id} />

<!-- {#if config !== undefined}
<div id="config">

     <div>

 <Slider bind:value={config.circleThickness} min={0} max={1.0} step={0.01}  displayMarkers />


        <Textfield
          type="range"
          min="1"
          max="200"
          step="10"
          class="shaped-outlined"
          variant="outlined"
          bind:value={config.maxValue}
          label="Minimum Value {config.maxValue}"
          input$aria-controls="helper-text-shaped-outlined-a"
          input$aria-describedby="helper-text-shaped-outlined-a" />
        <HelperText id="helper-text-shaped-outlined-a">Helper Text</HelperText>
    </div>

</div>
{/if} -->
<!-- 
  export let minValue = 0;
  export let maxValue = 1800;
  export let circleThickness = 0.1;
  export let circleFillGap = 0.05;
  export let circleColor = "#6bb9f0";
  export let waveHeight = 0.05;
  export let waveCount = 3;
  export let waveRiseTime = 2000;
  export let waveAnimateTime = 1000;
  export let waveRise = true;
  export let waveHeightScaling = true;
  export let waveAnimate = true;
  export let waveColor = "#89c4f4";
  export let waveOffset = 0;
  export let textVertPosition = 0.52;
  export let textSize = 0.6;
  export let valueCountUp = true;
  export let displayPercent = false;
  export let textColor = "#3498db";
  export let waveTextColor = "#3498db"; -->
