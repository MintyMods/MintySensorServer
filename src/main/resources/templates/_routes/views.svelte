<script>
  import "./_scss/_views.scss";
  import { onMount, tick, beforeUpdate } from "svelte";
  import Grid from "svelte-grid";
  import gridHelp from "svelte-grid/build/helper/index.mjs";
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart";
  import JustGageSample2 from "../_samples/JustGageSample2";
  import TempsBarChart from "../_samples/TempsBarChart";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill";
  import PowerLineChart from "../_samples/PowerLineChart";
  import JustGageSample1 from "../_samples/JustGageSample1";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample";
  import LinearGaugeSample from "../_samples/LinearGaugeSample";
  import JustGageSample3 from "../_samples/JustGageSample3";
  import RadialGaugeSample from "../_samples/RadialGaugeSample";
  import Card, { Actions, ActionButtons, ActionIcons } from "@smui/card";
  import IconButton, { Icon } from "@smui/icon-button";

  export let aspectRatio = "square";
  export let ripple = false;
  let adjustAfterRemove = false;

  let charts = [
    WaterTempLiquidFill,
    EchartsLiquidFillSample,
    JustGageSample2,
    ClockSpeedsBarChart,
    TempsBarChart,
    JustGageSample1,
    PowerLineChart,
    LinearGaugeSample,
    JustGageSample3,
    RadialGaugeSample
  ];

  let breakpoints = [[1100, 5], [800, 4], [530, 1]];
  let instances = [];
  let hover = false;
  let items;
  let cols = 5;

  onMount(async () => {
    await tick();
    buildLayout();
    await tick();
    buildCharts();
  });

  function getChart(id, i) {
    let ele = document.getElementById(id);
    if (ele !== null) {
      switch (i) {
        case 0:
          return new WaterTempLiquidFill({ target: ele });
        case 1:
          return new EchartsLiquidFillSample({ target: ele });
        case 2:
          return new JustGageSample2({ target: ele });
        case 3:
          return new ClockSpeedsBarChart({ target: ele });
        case 4:
          return new TempsBarChart({ target: ele });
        case 5:
          return new JustGageSample1({ target: ele });
        case 6:
          return new PowerLineChart({ target: ele });
        case 7:
          return new LinearGaugeSample({ target: ele });
        case 8:
          return new JustGageSample3({ target: ele });
        case 9:
          return new RadialGaugeSample({ target: ele });
      }
    }
  }

  function showToolBar(id) {
    document.getElementById("toolbar-" + id).classList.add("toolbar-active");
  }
  function hideToolBar(id) {
    document.getElementById("toolbar-" + id).classList.remove("toolbar-active");
  }

  function buildLayout() {
    let layout = [];
    charts.forEach((chart, i) => {
      const y = Math.ceil(Math.random() * 4) + 1;
      let current = gridHelp.item({
        x: (i * 2) % cols,
        y: Math.floor(i / 6) * y,
        w: 4,
        h: y,
        useTransform: true,
        id: Math.random()
          .toString(36)
          .substr(2, 9)
      });
      layout.push(current);
    });
    // Helper function which normalize. you need to pass items and columns
    items = gridHelp.resizeItems(layout, cols);
    console.log("Layout sorted: " + items);
  }

  function buildCharts() {
    charts.forEach((chart, i) => {
      let id = items[i].id;
      instances[i] = getChart(id, i);
      console.log("Instances: " + instances);
    });
    gridHelp.resizeItems(items, cols);
  }

  function showConfig(layout) {
    // expandContainer(id);
    items.some((item, i) => {
      if (item.id === layout.id) {
        hideToolBar(layout.id);
        instances[i].showConfig();
        return true;
      }
    });
  }

  function removeContainer(item) {
    let toolbar = document.getElementById("toolbar-" + item.id);
    toolbar.classList.add("toolbar-confirm");
    toolbar.querySelector(".mdc-card__actions").style.display = "none";

    if (false) {
      items = items.filter(value => value.id !== item.id);
      if (adjustAfterRemove) {
        items = gridHelp.resizeItems(items, cols);
      }
    }
  }

  function pinItemContainer(item) {
    item.static = !item.static;
    gridHelp.resizeItems(items, cols);
  }

  function expandContainer(id) {
    let wrapper = document.getElementById(id);
  }
</script>

<style>
  :global(.toolbar-confirm) {
    background-color: var(--theme-error) !important;
    color: var(--theme-on-error) !important;
    display: flex;
    flex-direction: row;
    align-items: center;
    box-sizing: border-box;
    min-height: 52px;
    padding: 8px;
  }

  :global(.toolbar-confirm)::before {
    content: "\f007";
    /* content: "<i class='fas fa-check'></i>"; */
    font-family: "Font Awesome 5 Pro";
    font-weight: 900;
    text-rendering: auto;
  -webkit-font-smoothing: antialiased;
  }
  .content {
    width: 100%;
    height: 100%;
    color: black;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: large;
  }
  :global(.svlt-grid-shadow) {
    background: rgba(228, 226, 226, 0.863);
    border: 1px dashed rgba(68, 68, 68, 0.514);
    transition: transform 0.2s;
  }
  :global(.svlt-grid-container) {
    background: #eee;
  }
  :global(.svlt-grid-transition > svlt-grid-item) {
    transition: transform 0.2s;
  }
  :global(.svlt-grid-shadow) {
  }
  .margin-b {
    margin-bottom: 10px;
  }
  /* on:click={removeContainer.bind(null, item)}> */
</style>

<div class="container margin-b">
  {#if items !== undefined}
    <Grid
      {breakpoints}
      {charts}
      {cols}
      gap={10}
      rowHeight={100}
      fillEmpty={false}
      useTransform={true}
      static={true}
      bind:items
      let:item>
      <div
        id={item.id}
        class="content"
        style="background: {item.static ? '#ccccee' : item.data}"
        on:mouseenter={() => showToolBar(item.id)}
        on:mouseleave={() => hideToolBar(item.id)}>

        <div class="toolbar-wrapper">
          <div id={'toolbar-' + item.id} class:hover class="toolbar">
            <Actions>
              <ActionIcons>
                <IconButton
                  {ripple}
                  class="material-icons"
                  on:click={() => showConfig(item)}
                  title="Edit">
                  <i class="fal fa-cogs fa-fw" />
                </IconButton>
                <IconButton
                  {ripple}
                  class="material-icons"
                  title="Delete"
                  on:click={() => removeContainer(item, this)}>
                  <i class="fal fa-trash-alt fa-fw" />
                </IconButton>
                <IconButton
                  {ripple}
                  class="material-icons primary"
                  title="Pin"
                  on:click={() => pinItemContainer(item)}>
                  <i class="fal fa-thumbtack fa-fw" />
                </IconButton>
              </ActionIcons>
            </Actions>
          </div>
        </div>

      </div>
    </Grid>
  {/if}
</div>
