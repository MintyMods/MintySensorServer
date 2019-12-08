<script>
  import { onMount, tick, getContext, setContext } from "svelte";
  import { createEventDispatcher } from "svelte";
  import { tabs } from "../common/constants.js";
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
  import { attributes } from "./defaults.js";
  import About from "../common/About";
  import AxisFontSize from "../common/AxisFontSize";
  import AxisRoughness from "../common/AxisRoughness";
  import AxisStrokeWidth from "../common/AxisStrokeWidth";
  import Bowing from "../common/Bowing";
  import Color from "../common/Color";
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
  import Title from "../common/Title"; //@todo
  import TitleFontSize from "../common/TitleFontSize";
  import TooltipFontSize from "../common/TooltipFontSize";
  import XLabel from "../common/XLabel";
  import YLabel from "../common/YLabel";
  import Top from "../common/Top";
  import Bottom from "../common/Bottom";
  import Right from "../common/Right";
  import Left from "../common/Left";
  import Width from "../common/Width";
  import Height from "../common/Height";

  export let values;
  export let labels;
  let dialog;
  let clone;
  let activeTab;
  let previewPromiseResolve;
  let getInstance = getContext("MSS:chart:Instance");
  let previewPromise = new Promise(
    resolve => (previewPromiseResolve = resolve)
  );
  setContext("MSS:chart:Preview", getPreviewInstancePromise);
  const dispatch = createEventDispatcher();

  onMount(async () => {
    let config = await getInstance();
    clone = { ...config };
    previewPromiseResolve(clone);
  });

  function getPreviewInstancePromise() {
    return previewPromise;
  }

  export const openDialog = () => {
    dialog && dialog.open();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  function moveDialogToBody() {
    // @todo Remove this Janky worksround
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    dialog.listen("MDCDialog:opened", () => {
      var newParent = document.getElementById("body");
      var oldParent = document.getElementById("dialog-fix-wrapper");
      while (oldParent.childNodes.length > 0) {
        newParent.appendChild(oldParent.childNodes[0]);
      }
    });
  }

  $: if (dialog) {
    moveDialogToBody();
  }
</script>

<style>
  #preview-wrapper {
    height: 200px;
    overflow: auto;
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
          <BarHorizontalConfigPreview {labels} {values} />
        </div>
        <div class="config-wrapper">

          <TabBar {tabs} let:tab minWidth bind:active={activeTab}>
            <Tab {tab}>
              <Icon class={tab.icon} />
              <Label>{tab.label}</Label>
            </Tab>
          </TabBar>

          {#if activeTab && activeTab.id === 'data'}
            <SensorGroup />
          {:else if activeTab && activeTab.id === 'chart'}
            <Color
              {...clone}
              on:color={event => (clone.color = event.detail)} />
            <Highlight
              {...clone}
              on:highlight={event => (clone.highlight = event.detail)} />
            <Width
              {...clone}
              on:width={event => (clone.width = event.detail)} />
            <Height
              {...clone}
              on:height={event => (clone.height = event.detail)} />
            <Interactive
              {...clone}
              on:interactive={event => (clone.interactive = event.detail)} />
          {:else if activeTab && activeTab.id === 'stroke'}
            <FillStyle
              {...clone}
              on:fillStyle={event => (clone.fillStyle = event.detail)} />
            <Stroke
              {...clone}
              on:stroke={event => (clone.stroke = event.detail)} />
            <StrokeWidth
              {...clone}
              on:strokeWidth={event => (clone.strokeWidth = event.detail)} />
            <InnerStrokeWidth
              {...clone}
              on:innerStrokeWidth={event => (clone.innerStrokeWidth = event.detail)} />
            <AxisStrokeWidth
              {...clone}
              on:axisStrokeWidth={event => (clone.axisStrokeWidth = event.detail)} />
            <FillWeight
              {...clone}
              on:fillWeight={event => (clone.fillWeight = event.detail)} />
          {:else if activeTab && activeTab.id === 'style'}
            <Roughness
              {...clone}
              on:roughness={event => (clone.roughness = event.detail)} />
            <AxisRoughness
              {...clone}
              on:axisRoughness={event => (clone.axisRoughness = event.detail)} />
            <Bowing
              {...clone}
              on:bowing={event => (clone.bowing = event.detail)} />
            <Simplification
              {...clone}
              on:simplification={event => (clone.simplification = event.detail)} />
          {:else if activeTab && activeTab.id === 'label'}
            <FontFamily
              {...clone}
              on:fontFamily={event => (clone.fontFamily = event.detail)} />
            <Title
              {...clone}
              on:title={event => (clone.title = event.detail)} />
            <XLabel
              {...clone}
              on:xLabel={event => (clone.xLabel = event.detail)} />
            <YLabel
              {...clone}
              on:yLabel={event => (clone.yLabel = event.detail)} />
          {:else if activeTab && activeTab.id === 'size'}
            <LabelFontSize
              {...clone}
              on:labelFontSize={event => (clone.labelFontSize = event.detail)} />
            <TitleFontSize
              {...clone}
              on:titleFontSize={event => (clone.titleFontSize = event.detail)} />
            <TooltipFontSize
              {...clone}
              on:tooltipFontSize={event => (clone.tooltipFontSize = event.detail)} />
            <AxisFontSize
              {...clone}
              on:axisFontSize={event => (clone.axisFontSize = event.detail)} />
          {:else if activeTab && activeTab.id === 'spacing'}
            <Top
              {...clone.margin}
              on:top={event => (clone.margin.top = event.detail)} />
            <Right
              {...clone.margin}
              on:right={event => (clone.margin.right = event.detail)} />
            <Bottom
              {...clone.margin}
              on:bottom={event => (clone.margin.bottom = event.detail)} />
            <Left
              {...clone.margin}
              on:left={event => (clone.margin.left = event.detail)} />
            <Padding
              {...clone}
              on:padding={event => (clone.padding = event.detail)} />
          {:else if activeTab && activeTab.id === 'about'}
            <About />
          {:else}
            <h1 class="error">Error...</h1>
          {/if}

        </div>
      </div>
    </Content>
    <Actions>
      <Button action="save" on:click={() => dispatch('save', clone)}>
        <Label>Save</Label>
      </Button>
      <Button action="cancel" default use={[InitialFocus]}>
        <Label>Cancel</Label>
      </Button>
    </Actions>
  </Dialog>
</Content>
