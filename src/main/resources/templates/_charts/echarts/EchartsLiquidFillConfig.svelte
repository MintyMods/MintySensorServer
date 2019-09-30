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
    direction,
    color,
    shape
  } from "../../_stores/echarts-liquid-fill-store.js";

  const SHAPES = [
    { type: "circle", desc: "Circle", icon: "fal fa-circle fa-fw" },
    { type: "rect", desc: "Rectangle", icon: "fal fa-rectangle-landscape fa-fw" },
    { type: "roundRect", desc: "Rounded Rectangle", icon: "fad fa-rectangle-landscape fa-fw" },
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

  export let config;
  export let data;
  let dialog;
  //   $: config;
  let index = 0;

  afterUpdate(async () => {
    await tick();
    initPickr();
  });

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
    config = options;
    data = data;
    dialog.open();
    initPickr();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  function changeColour(ele) {
    console.log(ele);
  }

  let directionChecked = true;
  $: $direction = directionChecked ? "right" : "left";
  $: $color;
</script>

<style>
  .dialog-wrapper {
    width: 100%;
    height: 100vh;
  }

</style>

<div class="dialog-wrapper">
  <Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">

    {#if data !== undefined}
      <Title id="title">
        {#if Array.isArray(data)}
          <TabBar tabs={data} let:tab>
            <Tab {tab}>
              <Label>{tab}</Label>
            </Tab>
          </TabBar>
        {:else}{data.label.desc}{/if}
      </Title>
    {/if}
    <Content id="content">
      {#if config !== undefined}
        <!-- WAVE COLOURS      -->
        {#each $color as color, i}
          <Textfield bind:value={color} label="Wave Colour">
            <div class="color-picker" />
          </Textfield>
        {/each}

        <!-- SHAPE -->
        <Select
          enhanced
          bind:value={config.series[index].shape}
          label="Shape of water fill chart. {$shape}"
          class="shape"
          menu$class="shape">
          <Option value="" />
          {#each SHAPES as item}
            <Option value={item.type} selected={shape === item.type} >
              <i class={item.icon}> </i> {item.desc}
            </Option>
          {/each}
        </Select>

        <!-- WAVE DIRECTION -->
        <FormField>
          <Switch bind:checked={directionChecked} />
          <span slot="label">Wave direction {$direction}</span>
        </FormField>
      {/if}
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
</div>
<!-- amplitude: 0,
          waveAnimation: 0,
          silent: true,
          color: ["#294D99", "#156ACF", "#1598ED", "#45BDFF"], //Wave colors.
          center: ["50%", "50%"],
          radius: "50%",
          amplitude: "8%",
          waveLength: "80%",
          phase: "auto",
          period: "auto",
          direction: "right",
          shape: "roundRect",
          waveAnimation: true,
          animationEasing: "linear",
          animationEasingUpdate: "linear",
          animationDuration: 2000,
          animationDurationUpdate: 1000,
          outline: {
            show: true,
            borderDistance: 1,
            itemStyle: {
              color: "none",
              borderColor: "rgba(21,137,200,0.5)",
              borderWidth: 6,
              shadowBlur: 0,
              shadowColor: "rgba(0, 0, 0, 0.25)"
            }
          },
          backgroundStyle: {
            color: "#E3F7FF"
          },
          itemStyle: {
            opacity: 0.2,
            shadowBlur: 0,
            shadowColor: "rgba(0, 0, 0, 0.1)"
          },
          label: {
            show: true,
            color: "#294D99",
            insideColor: "#fff",
            fontSize: 15,
            fontWeight: "bold",
            align: "center",
            baseline: "middle",
            position: "inside"
          }, -->
