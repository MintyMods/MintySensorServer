<script>
  import { afterUpdate, onMount, tick } from "svelte";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Button from "@smui/button";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text";
  //   import Slider from "@smui/slider";
  import Select, { Option } from "@smui/select";
  import Tab, { Icon, Label } from "@smui/tab";
  import TabBar from "@smui/tab-bar";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

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
  } from "../../_stores/echarts-liquid-fill-store.js";

  const SHAPES = [
    { type: "circle", desc: "Circle", icon: "fal fa-circle fa-fw" },
    {
      type: "rect",
      desc: "Rectangle",
      icon: "fal fa-rectangle-landscape fa-fw"
    },
    {
      type: "roundRect",
      desc: "Rounded Rectangle",
      icon: "fad fa-rectangle-landscape fa-fw"
    },
    { type: "triangle", desc: "Triangle", icon: "fal fa-triangle fa-fw" },
    { type: "diamond", desc: "Diamond", icon: "fal fa-diamond fa-fw" },
    { type: "pin", desc: "Pin", icon: "fal fa-map-marker fa-fw" },
    { type: "arrow", desc: "Arrow", icon: "fal fa-arrow-alt-up fa-fw" }
  ];
  const EASING = [
    "linear",
    "ease",
    "ease-in",
    "ease-out",
    "ease-in-out",
    "step-start",
    "step-end"
  ];
  const ALIGN = ["left", "center", "right"];
  const POSTITION = ["inside", "left", "right", "top", "bottom"];
  const FONT_WEIGHT = ["normal", "bold", "bolder", "lighter"];

  export let data;
  let dialog;

  // afterUpdate(async () => {
  //   await tick();
  //   initPickr();
  // });

  function initPickr() {
    let pickers = document.querySelectorAll(".color-picker");
    pickers.forEach(picker => {
      Pickr.create({
        el: picker,
        theme: "nano",
        components: {
          preview: true,
          opacity: true,
          hue: true,
          interaction: {
            rgba: false,
            input: false,
            save: true,
            cancel: false
          }
        }
      });
    });
  }

  export const openDialog = (options, data) => {
    data = data;
    dialog.open();
    // initPickr();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  function changeColour(ele) {
    console.log(ele);
  }

  let directionChecked = true;
  $: $direction = directionChecked ? "right" : "left";
  let outlineShowChecked = true;
  $: $outlineShow = outlineShowChecked;

  let shapeSelected;
  $: $shape = shapeSelected;

  let colorText;
  $: $color = colorText;
  // $: console.log("COLOR:" + color);
</script>

<style>
  .dialog-wrapper {
    width: 100%;
    height: 100vh;
  }
  .current-value {
    font-size: small;
    color: lightgrey;
  }
  /* :global(dialog)::backdrop {
    background: rgba(255, 0, 0, 0.5);
  } */
</style>


  {#if data !== undefined}
<!-- <div class="dialog-wrapper"> -->
<Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">
    <Title id="title">
      {#if Array.isArray(data)}
        <TabBar tabs={data} let:tab>
          <Tab {tab}>
            <Label>{tab}</Label>
          </Tab>
        </TabBar>
      {:else}{data.label.desc}{/if}
    </Title>
  <Content id="content">
    <!-- {#if config !== undefined} -->
    <!-- WAVE COLOURS      -->
    <!-- {#each $color as color, i} -->
    <!-- <Textfield bind:value={colorText} label="Wave Colour" />
      <div class="color-picker" /> -->
    <!-- {/each} -->

    <!-- SHAPE -->
    <Select
      enhanced
      bind:value={shapeSelected}
      label="Guage shape "
      class="shape"
      menu$class="shape">
      <Option value="" />
      {#each SHAPES as item}
        <Option value={item.type} selected={shapeSelected === item.type}>
          <i class={item.icon} />
          {item.desc}
        </Option>
      {/each}
    </Select>
    <br />
    <!-- WAVE DIRECTION -->
    <FormField>
      <Switch bind:checked={directionChecked} />
      <span slot="label">
        Wave direction
        <span class="current-value">{$direction}</span>
      </span>
    </FormField>
    <br />
    <!-- SHOW OUTLINE  -->
    <FormField>
      <Switch bind:checked={outlineShowChecked} />
      <span slot="label">
        Show Outline
        <span class="current-value">{$outlineShow}</span>
      </span>
    </FormField>
    <!-- {/if} -->
  </Content>
  <Actions>
    <Button action="save">
      <Label>Save</Label>
    </Button>
    <Button action="cancel" default use={[InitialFocus]}>
      <Label>Cancel</Label>
    </Button>
  </Actions>
</Dialog>
<!-- </div> -->
  {/if}
