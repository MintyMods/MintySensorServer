<script>
  import { afterUpdate, onMount, tick } from "svelte";
  import { createEventDispatcher } from "svelte";
  import { TABS } from "./config/constants.js";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
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
  const dispatch = createEventDispatcher();

  export const openDialog = item => {
    dialog && dialog.open();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  let dialog;
  let activeTab;
  //<Media class="card-media-16x9" aspectRatio="16x9">

  $: if (dialog) {
    fixDialogIssueWithSvelteGrid();
  }

  function fixDialogIssueWithSvelteGrid() {
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    dialog.listen("MDCDialog:opened", () => {
      var newParent = document.getElementById("body");
      var oldParent = document.getElementById("dialog-fix-wrapper");
      while (oldParent.childNodes.length > 0) {
        newParent.appendChild(oldParent.childNodes[0]);
      }
    });
  }

 $: dialog && dialog.open();
</script>

<style>
  .config-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
  }
</style>

<div id="dialog-fix-wrapper">
  <Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">
    <div id="preview">
      <span class="place-holder" />
    </div>

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
    <Content class="content" id="content">
      <div class="config-wrapper">

        <TabBar tabs={TABS} let:tab minWidth bind:active={activeTab}>
          <Tab {tab}>
            <Icon class={tab.icon} />
            <Label>{tab.label}</Label>
          </Tab>
        </TabBar>

        {#if activeTab && activeTab.id === 'data'}
          <div />
        {:else if activeTab && activeTab.id === 'layout'}
          <Center {center} on:center />
          <Amplitude {amplitude} on:amplitude />
          <WaveLength {waveLength} on:waveLength />
          <Radius {radius} on:radius />
        {:else if activeTab && activeTab.id === 'wave'}
          <!-- <Color {color} on:color /> -->
          <Shape {shape} on:shape />
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
          <LabelColor {labelColor} on:labelColor />
          <LabelInsideColor {labelInsideColor} on:labelInsideColor />
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
