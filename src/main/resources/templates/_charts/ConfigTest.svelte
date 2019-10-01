<script language="JavaScript">
  import "./_scss/_chart_card.scss";
  import Card, {
    Content,
    PrimaryAction,
    Media,
    MediaContent,
    Actions,
    ActionButtons,
    ActionIcons
  } from "@smui/card";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Button, { Label } from "@smui/button";
  import Button, { Label } from "@smui/button";
  import IconButton, { Icon } from "@smui/icon-button";
  import List, { Item, Text } from "@smui/image-list";
  import Div from "@smui/common/Div.svelte";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill";
  import { beforeUpdate } from "svelte";
  import { Configurable } from "../_components/Configurable.svelte";

export let aspectRatio = "square";
  export let ripple = false;
  let hover = false;


  export let data;
  export let config;
  let dialog;
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
        gauge = loadLiquidFillGauge(id, data, getConfig(data));
      }
      gauge.update(data.value);
    }
  });

  function getConfig(data) {
    let config = liquidFillGaugeDefaultSettings();
    config.minValue = 0;
    config.maxValue = 1800;
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
    // config.displayUnit = " " + data.unit;
    return config;
  }

  $: if (config != undefined) {
    config = undefined;
    debugger;
  
  }
  function scrim() {
    console.log("scrim");
  }

  export function open(...args) {
    return dialog.open(...args);
  }
</script>

<style>
  svg {
    opacity: 0.5;
    width: 98%;
    height: 98%;
    overflow: hidden;
    transform: scale(0.8);
  }
</style>

<svg {id} />

<Dialog
  scrimClickAction={() => scrim()}
  bind:this={dialog}
  aria-labelledby="simple-title"
  aria-describedby="simple-content">
  <!-- Title cannot contain leading whitespace due to mdc-typography-baseline-top() -->
  <Title id="simple-title">Dialog Title</Title>
  <Content id="simple-content">Super awesome dialog body text?</Content>
  <Actions>
    <Button>
      <Label>No</Label>
    </Button>
    <Button>
      <Label>Yes</Label>
    </Button>
  </Actions>
</Dialog>