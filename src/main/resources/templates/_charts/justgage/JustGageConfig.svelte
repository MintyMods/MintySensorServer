<script>
  import { afterUpdate, onMount, tick } from "svelte";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import TabBar from "@smui/tab-bar";

  // Configuration Input Fields
  import About from "./config/About";
  import Shape from "./config/Shape";

  let iconTabs = [
    { id: "data", icon: "fad fa-layer-plus", label: "Data" },
    { id: "wave", icon: "fad fa-water", label: "Wave" },
    { id: "outline", icon: "fad fa-border-all", label: "Outline" },
    { id: "background", icon: "fal fa-chess-board", label: "Background" },
    { id: "label", icon: "fad fa-text-size", label: "Label" },
    { id: "layout", icon: "fad fa-arrows-alt", label: "Layout" },
    { id: "animation", icon: "fad fa-camera-movie", label: "Animation" },
    { id: "about", icon: "fad fa-info-circle", label: "About" }
  ];

  export let data;


  export const openDialog = item => {
    data = data;
    dialog && dialog.open();
  };

  export const closeDialog = () => {
    dialog.close();
  };

  let dialog;
  let shapeSelected;
  let activeTab;

  $: dialog && dialog.open(); // @todo remove after issue seen
</script>

<style>
  .config-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
  }
</style>

{#if data !== undefined}
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
    <Content class="content" id="content">
      <div class="config-wrapper">

        <TabBar tabs={iconTabs} let:tab minWidth bind:active={activeTab}>
          <Tab {tab}>
            <Icon class={tab.icon} />
            <Label>{tab.label}</Label>
          </Tab>
        </TabBar>

        {#if activeTab && activeTab.id === 'data'}
      <div></div>
        {:else if activeTab && activeTab.id === 'layout'}
          <Center />
          <Amplitude />
          <WaveLength />
          <Radius />
          <Shape />
        {:else if activeTab && activeTab.id === 'wave'}
          <Color />
          <ItemStyleShadowColor />
          <ItemStyleShadowBlur />
          <ItemStyleOpacity />
          <EmphasisItemStyleOpacity />
        {:else if activeTab && activeTab.id === 'outline'}
          <OutlineitemStyleColor />
          <OutlineitemStyleBorderColor />
          <OutlineitemStyleShadowColor />
          <OutlineBorderDistance />
          <OutlineitemStyleBorderWidth />
          <OutlineitemStyleShadowBlur />
          <OutlineShow />
        {:else if activeTab && activeTab.id === 'background'}
          <BackgroundStyleColor />
          <BackgroundStyleBorderColor />
          <BackgroundStyleItemStyleShadowColor />
          <BackgroundStyleBorderWidth />
          <BackgroundStyleItemStyleOpacity />
          <BackgroundStyleItemStyleShadowBlur />
        {:else if activeTab && activeTab.id === 'label'}
          <LabelColor/>
          <LabelInsideColor/>
          <LabelFontSize/>
          <LabelFontWeight/>
          <LabelAlign/>
          <LabelBaseline/>
          <LabelPosition/>
          <LabelShow/>
        {:else if activeTab && activeTab.id === 'animation'}
          <Period />
          <AnimationDuration />
          <AnimationDurationUpdate />
          <AnimationEasing />
          <AnimationEasingUpdate />
          <WaveAnimation />
          <Direction />
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
{/if}
