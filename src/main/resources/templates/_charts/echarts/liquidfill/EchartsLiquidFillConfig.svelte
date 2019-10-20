<script>
  import { afterUpdate, onMount, tick } from "svelte";
  import { createEventDispatcher } from "svelte";
  import { TABS } from "./config/constants.js";
  import EchartsLiquidFillConfigPreview from "./EchartsLiquidFillConfigPreview";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import SensorGroup from "../../../_components/SensorGroup";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Card, { Media, MediaContent } from "@smui/card";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import TabBar from "@smui/tab-bar";
  import About from "./config/About";
  import Shape from "./config/Shape";
  import Color from "./config/Color";
  import Direction from "./config/Direction";
  import OutlineShow from "./config/OutlineShow";
  import Center from "./config/Center";
  import Radius from "./config/Radius";
  import Amplitude from "./config/Amplitude";
  import WaveLength from "./config/WaveLength";
  import Period from "./config/Period";
  import WaveAnimation from "./config/WaveAnimation";
  import AnimationEasing from "./config/AnimationEasing";
  import AnimationEasingUpdate from "./config/AnimationEasingUpdate";
  import AnimationDuration from "./config/AnimationDuration";
  import AnimationDurationUpdate from "./config/AnimationDurationUpdate";
  import OutlineBorderDistance from "./config/OutlineBorderDistance";
  import OutlineitemStyleColor from "./config/OutlineitemStyleColor";
  import OutlineitemStyleBorderColor from "./config/OutlineitemStyleBorderColor";
  import OutlineitemStyleBorderWidth from "./config/OutlineitemStyleBorderWidth";
  import OutlineitemStyleShadowBlur from "./config/OutlineitemStyleShadowBlur";
  import OutlineitemStyleShadowColor from "./config/OutlineitemStyleShadowColor";
  import BackgroundStyleColor from "./config/BackgroundStyleColor";
  import BackgroundStyleBorderWidth from "./config/BackgroundStyleBorderWidth";
  import BackgroundStyleBorderColor from "./config/BackgroundStyleBorderColor";
  import BackgroundStyleItemStyleShadowBlur from "./config/BackgroundStyleItemStyleShadowBlur";
  import BackgroundStyleItemStyleShadowColor from "./config/BackgroundStyleItemStyleShadowColor";
  import BackgroundStyleItemStyleOpacity from "./config/BackgroundStyleItemStyleOpacity";
  import ItemStyleOpacity from "./config/ItemStyleOpacity";
  import ItemStyleShadowBlur from "./config/ItemStyleShadowBlur";
  import ItemStyleShadowColor from "./config/ItemStyleShadowColor";
  import EmphasisItemStyleOpacity from "./config/EmphasisItemStyleOpacity";
  import LabelShow from "./config/LabelShow";
  import LabelColor from "./config/LabelColor";
  import LabelInsideColor from "./config/LabelInsideColor";
  import LabelFontSize from "./config/LabelFontSize";
  import LabelFontWeight from "./config/LabelFontWeight";
  import LabelAlign from "./config/LabelAlign";
  import LabelBaseline from "./config/LabelBaseline";
  import LabelPosition from "./config/LabelPosition";

  export let color;
  export let center = ["50%", "50%"];
  export let radius;
  export let amplitude;
  export let waveLength;
  export let period;
  export let direction;
  export let shape;
  export let waveAnimation;
  export let animationEasing;
  export let animationEasingUpdate;
  export let animationDuration;
  export let animationDurationUpdate;
  export let outlineShow;
  export let outlineBorderDistance;
  export let outlineitemStyleColor;
  export let outlineitemStyleBorderColor;
  export let outlineitemStyleBorderWidth;
  export let outlineitemStyleShadowBlur;
  export let outlineitemStyleShadowColor;
  export let backgroundStyleColor;
  export let backgroundStyleBorderWidth;
  export let backgroundStyleBorderColor;
  export let backgroundStyleItemStyleShadowBlur;
  export let backgroundStyleItemStyleShadowColor;
  export let backgroundStyleItemStyleOpacity;
  export let itemStyleOpacity;
  export let itemStyleShadowBlur;
  export let itemStyleShadowColor;
  export let emphasisItemStyleOpacity;
  export let labelShow;
  export let labelColor;
  export let labelInsideColor;
  export let labelFontSize;
  export let labelFontWeight;
  export let labelAlign;
  export let labelBaseline;
  export let labelPosition;
  export let showConfigurationDialog;
  export let data;
  export let chart;
  export let owner;
  const dispatch = createEventDispatcher();

  export const openDialog = item => {
    dialog && dialog.open();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  let dialog;
  let activeTab;

  $: if (dialog) {
    moveDialogToBody();
  }

  function moveDialogToBody() {
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    dialog.listen("MDCDialog:opened", () => {
      var newParent = document.getElementById("body");
      var oldParent = document.getElementById("dialog-fix-wrapper");
      while (oldParent.childNodes.length > 0) {
        newParent.appendChild(oldParent.childNodes[0]);
      }
    });
  }

  $: dialog && dialog.open(); // @todo remove
</script>

<style>
  .config-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
  }
  .preview-wrapper {
    min-width:400px;
    height:300px;
  }
</style>

<div id="dialog-fix-wrapper">
  <Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">
    <Title id="title"><i class="fad fa-water fa-1x"></i> ECharts Liquid Fill</Title>
    <Content class="content" id="content">
      <div class="preview-wrapper">
        <EchartsLiquidFillConfigPreview
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
          {labelPosition} />
      </div>
      <div class="config-wrapper">

        <TabBar tabs={TABS} let:tab minWidth bind:active={activeTab}>
          <Tab {tab}>
            <Icon class={tab.icon} />
            <Label>{tab.label}</Label>
          </Tab>
        </TabBar>

        {#if activeTab && activeTab.id === 'data'}
          <SensorGroup />
        {:else if activeTab && activeTab.id === 'layout'}
          <Center {center} on:center />
          <Amplitude {amplitude} on:amplitude />
          <WaveLength {waveLength} on:waveLength />
          <Radius {radius} on:radius />
        {:else if activeTab && activeTab.id === 'wave'}
          <!-- <Color {color} on:color /> -->
          <LabelColor {labelColor} on:labelColor />
          <LabelInsideColor {labelInsideColor} on:labelInsideColor />
          <ItemStyleShadowColor
            {itemStyleShadowColor}
            on:itemStyleShadowColor />
          <ItemStyleShadowBlur {itemStyleShadowBlur} on:itemStyleShadowBlur />
          <ItemStyleOpacity {itemStyleOpacity} on:itemStyleOpacity />
          <EmphasisItemStyleOpacity
            {emphasisItemStyleOpacity}
            on:emphasisItemStyleOpacity />
        {:else if activeTab && activeTab.id === 'outline'}
          <OutlineitemStyleColor
            {outlineitemStyleColor}
            on:outlineitemStyleColor />
          <OutlineitemStyleBorderColor
            {outlineitemStyleBorderColor}
            on:outlineitemStyleBorderColor />
          <OutlineitemStyleShadowColor
            {outlineitemStyleShadowColor}
            on:outlineitemStyleShadowColor />
          <OutlineBorderDistance
            {outlineBorderDistance}
            on:outlineBorderDistance />
          <OutlineitemStyleBorderWidth
            {outlineitemStyleBorderWidth}
            on:outlineitemStyleBorderWidth />
          <OutlineitemStyleShadowBlur
            {outlineitemStyleShadowBlur}
            on:outlineitemStyleShadowBlur />
          <OutlineShow {outlineShow} on:outlineShow />
        {:else if activeTab && activeTab.id === 'background'}
          <BackgroundStyleColor
            {backgroundStyleColor}
            on:backgroundStyleColor />
          <BackgroundStyleBorderColor
            {backgroundStyleBorderColor}
            on:backgroundStyleBorderColor />
          <BackgroundStyleItemStyleShadowColor
            {backgroundStyleItemStyleShadowColor}
            on:backgroundStyleItemStyleShadowColor />
          <Shape {shape} on:shape />
          <BackgroundStyleBorderWidth
            {backgroundStyleBorderWidth}
            on:backgroundStyleBorderWidth />
          <BackgroundStyleItemStyleOpacity
            {backgroundStyleItemStyleOpacity}
            on:backgroundStyleItemStyleOpacity />
          <BackgroundStyleItemStyleShadowBlur
            {backgroundStyleItemStyleShadowBlur}
            on:backgroundStyleItemStyleShadowBlur />
        {:else if activeTab && activeTab.id === 'label'}
          <LabelFontSize {labelFontSize} on:labelFontSize />
          <LabelFontWeight {labelFontWeight} on:labelFontWeight />
          <LabelAlign {labelAlign} on:labelAlign />
          <LabelBaseline {labelBaseline} on:labelBaseline />
          <LabelPosition {labelPosition} on:labelPosition />
          <LabelShow {labelShow} on:labelShow />
        {:else if activeTab && activeTab.id === 'animation'}
          <Period {period} on:period />
          <AnimationDuration {animationDuration} on:animationDuration />
          <AnimationDurationUpdate
            {animationDurationUpdate}
            on:animationDurationUpdate />
          <AnimationEasing {animationEasing} on:animationEasing />
          <AnimationEasingUpdate
            {animationEasingUpdate}
            on:animationEasingUpdate />
          <WaveAnimation {waveAnimation} on:waveAnimation />
          <Direction {direction} on:direction />
        {:else if activeTab && activeTab.id === 'about'}
          <About />
        {:else}
          <h1 class="error">Error - Please Report</h1>
        {/if}

      </div>
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
