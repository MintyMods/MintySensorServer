<script>
  import { afterUpdate, onMount, tick } from "svelte";
  import { createEventDispatcher } from "svelte";
  import { TABS } from "./config/constants.js";
  import BarHorizontalConfigPreview from "./BarHorizontalConfigPreview";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import SensorGroup from "../../../_components/SensorGroup";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Card, { Media, MediaContent } from "@smui/card";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import TabBar from "@smui/tab-bar";
  import About from "./config/About";
  import Color from "./config/Color";
  import ChartTitle from "./config/Title"; //@todo
  import AxisFontSize from "./config/AxisFontSize";
  import AxisRoughness from "./config/AxisRoughness";
  import AxisStrokeWidth from "./config/AxisStrokeWidth";
  import Bowing from "./config/Bowing";
  import FillStyle from "./config/FillStyle";
  import FillWeight from "./config/FillWeight";
  import Font from "./config/Font";
  import Highlight from "./config/Highlight";
  import InnerStrokeWidth from "./config/InnerStrokeWidth";
  import Interactive from "./config/Interactive";
  import LabelFontSize from "./config/LabelFontSize";
  import Margin from "./config/Margin";
  import Padding from "./config/Padding";
  import Roughness from "./config/Roughness";
  import Simplification from "./config/Simplification";
  import Stroke from "./config/Stroke";
  import StrokeWidth from "./config/StrokeWidth";
  import TitleFontSize from "./config/TitleFontSize";
  import TooltipFontSize from "./config/TooltipFontSize";
  import XLabel from "./config/XLabel";
  import YLabel from "./config/YLabel";
  import Legend from "./config/Legend";

  export let data;
  export let values;
  export let labels;
  export let chart;
  export let color;
  export let title;
  export let axisFontSize;
  export let axisRoughness;
  export let axisStrokeWidth;
  export let bowing;
  export let fillStyle;
  export let fillWeight;
  export let font;
  export let highlight;
  export let innerStrokeWidth;
  export let interactive;
  export let labelFontSize;
  export let margin;
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
  let dialog;
  let activeTab;
  const dispatch = createEventDispatcher();

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
  .config-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
  }
  .preview-wrapper {
    min-width: 400px;
    height: 300px;
  }
</style>

<div id="dialog-fix-wrapper">
  <Dialog bind:this={dialog} aria-labelledby="title" aria-describedby="content">
    <Title>RoughViz BarH</Title>
    <Content class="content" id="content">
      <div class="preview-wrapper">
        <BarHorizontalConfigPreview {data} />
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
        {:else if activeTab && activeTab.id === 'style'}
          <Color />
          <Highlight />
          <Bowing />
          <Roughness />
          <AxisRoughness />
          <Simplification />
          <Interactive />
        {:else if activeTab && activeTab.id === 'label'}
          <ChartTitle />
          <XLabel />
          <YLabel />
          <Font />
          <LabelFontSize />
          <TitleFontSize />
          <TooltipFontSize />
          <AxisFontSize />
          <Legend />
        {:else if activeTab && activeTab.id === 'stroke'}
          <FillStyle />
          <FillWeight />
          <Stroke />
          <StrokeWidth />
          <InnerStrokeWidth />
          <AxisStrokeWidth />
        {:else if activeTab && activeTab.id === 'margin'}
          <Margin />
        {:else if activeTab && activeTab.id === 'padding'}
          <Padding />
        {:else if activeTab && activeTab.id === 'about'}
          <About />
        {:else}
          <h1 class="error">Opps...</h1>
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
