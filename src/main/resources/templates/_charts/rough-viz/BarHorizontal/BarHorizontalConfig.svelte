<script>

  import { afterUpdate, onMount, tick ,onDestroy, getContext } from "svelte";
  import { createEventDispatcher } from "svelte";
  import { TABS } from "../common/constants.js";
  import BarHorizontalConfigPreview from "./BarHorizontalConfigPreview";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import SensorGroup from "../../../_components/SensorGroup";
  import Dialog, {
    Title as DialogTitle,
    Content,
    Actions,
    InitialFocus
  } from "@smui/dialog";
  import Card, { Media, MediaContent } from "@smui/card";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import TabBar from "@smui/tab-bar";
  import About from "../common/About";
  import Color from "../common/Color";
  import Width from "../common/Width";
  import Height from "../common/Height";
  import Circle from "../common/Circle";
  import CircleRadius from "../common/CircleRadius";
  import CircleRoughness from "../common/CircleRoughness";
  import ColorVar from "../common/ColorVar";
  import CurbZero from "../common/CurbZero";
  import Title from "../common/Title"; //@todo
  import AxisFontSize from "../common/AxisFontSize";
  import AxisRoughness from "../common/AxisRoughness";
  import AxisStrokeWidth from "../common/AxisStrokeWidth";
  import Bowing from "../common/Bowing";
  import FillStyle from "../common/FillStyle";
  import FillWeight from "../common/FillWeight";
  import FontFamily from "../common/FontFamily";
  import Highlight from "../common/Highlight";
  import InnerStrokeWidth from "../common/InnerStrokeWidth";
  import Interactive from "../common/Interactive";
  import LabelFontSize from "../common/LabelFontSize";
  import Padding from "../common/Padding";
  import Roughness from "../common/Roughness";
  import Simplification from "../common/Simplification";
  import Stroke from "../common/Stroke";
  import StrokeWidth from "../common/StrokeWidth";
  import TitleFontSize from "../common/TitleFontSize";
  import TooltipFontSize from "../common/TooltipFontSize";
  import XLabel from "../common/XLabel";
  import YLabel from "../common/YLabel";
  import Legend from "../common/Legend";
  import LegendPosition from "../common/LegendPosition";
  import Top from "../common/Top";
  import Bottom from "../common/Bottom";
  import Right from "../common/Right";
  import Left from "../common/Left";
  


  export let data;
  export let values;
  export let labels;
  export let chart;
  export let width;
  export let height;
  export let circle;
  export let circleRadius;
  export let circleRoughness;
  export let colorVar;
  export let curbZero;
  export let color;
  export let title;
  export let axisFontSize;
  export let axisRoughness;
  export let axisStrokeWidth;
  export let bowing;
  export let fillStyle;
  export let fillWeight;
  export let fontFamily;
  export let highlight;
  export let innerStrokeWidth;
  export let interactive;
  export let labelFontSize;
  export let top;
  export let bottom;
  export let right;
  export let left;
  export let padding;
  export let roughness;
  export let simplification;
  export let stroke;
  export let strokeWidth;
  export let titleFontSize;
  export let tooltipFontSize;
  export let xLabel;
  export let yLabel;
  export let legend;
  export let legendPosition;
  let dialog;
  let activeTab;
  const dispatch = createEventDispatcher();
  let getInstance = getContext("MSS:chart:getInstance");

  let previewPromiseResolve;
  let previewPromise = new Promise(resolve => previewPromiseResolve = resolve);
  
  setContext("MSS:chart:getInstance", getChartInstancePromise);

  let clone;
  onMount(async () => {
    config = await getInstance();
    clone = { ...config };
  });

  export const openDialog = () => {
    dialog && dialog.open();
  };

  export const closeDialog = () => {
    dialog.close();
  };

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
</script>

<style>
  #preview-wrapper {
    width: 100%;
    height: 200px;
    overflow: overlay;
    cursor: grab;
  }
</style>

<Content id="dialog-fix-wrapper">
  <Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">
    <DialogTitle>
      <i class="fad fa-chart-bar fa-rotate-90" />
      RoughViz BarH
    </DialogTitle>
    <Content class="content" id="content">
      <div class="flex-container">
        <div id="preview-wrapper">
          <BarHorizontalConfigPreview 
          {...chart}
           {labels}
            {values}
              on:color={event => (color = event.detail)}/>
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
          {:else if activeTab && activeTab.id === 'chart'}
            <Color {color} on:color />
            <Highlight {highlight} on:highlight />
            <ColorVar {colorVar} on:colorVar />
            <Width {width} on:width />
            <Height {height} on:height />
            <Interactive {interactive} on:interactive />
          {:else if activeTab && activeTab.id === 'stroke'}
            <FillStyle {fillStyle} on:fillStyle />
            <Stroke {stroke} on:stroke />
            <StrokeWidth {strokeWidth} on:strokeWidth />
            <InnerStrokeWidth {innerStrokeWidth} on:innerStrokeWidth />
            <AxisStrokeWidth {axisStrokeWidth} on:axisStrokeWidth />
            <FillWeight {fillWeight} on:fillWeight />
            <Circle {circle} on:circle />
          {:else if activeTab && activeTab.id === 'style'}
            <Roughness {roughness} on:roughness />
            <AxisRoughness {axisRoughness} on:axisRoughness />
            <CircleRoughness {circleRoughness} on:circleRoughness />
            <Bowing {bowing} on:bowing />
            <CircleRadius {circleRadius} on:circleRadius />
            <Simplification {simplification} on:simplification />
            <CurbZero {curbZero} on:curbZero />
          {:else if activeTab && activeTab.id === 'label'}
            <FontFamily {fontFamily} on:fontFamily />
            <Title {title} on:title />
            <XLabel {xLabel} on:xLabel />
            <YLabel {yLabel} on:yLabel />
            <LegendPosition {legendPosition} on:legendPosition />
            <Legend {legend} on:legend />
          {:else if activeTab && activeTab.id === 'size'}
            <LabelFontSize {labelFontSize} on:labelFontSize />
            <TitleFontSize {titleFontSize} on:titleFontSize />
            <TooltipFontSize {tooltipFontSize} on:tooltipFontSize />
            <AxisFontSize {axisFontSize} on:axisFontSize />
          {:else if activeTab && activeTab.id === 'spacing'}
            <Top {top} on:top />
            <Right {right} on:right />
            <Bottom {bottom} on:bottom />
            <Left {left} on:left />
            <Padding {padding} on:padding />
          {:else if activeTab && activeTab.id === 'about'}
            <About />
          {:else}
            <h1 class="error">Error...</h1>
          {/if}

        </div>
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
</Content>
