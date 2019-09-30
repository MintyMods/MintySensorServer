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
  let cols = 10;

  onMount(async () => {
    await tick();
    layout();
    await tick();
    build();
  });

  function getChart(id, i) {
    let ele = document.getElementById(id);
    console.log("Target: " + id + " : " + ele);

    if (ele !== null) {
      switch (i) {
        case 0:
          return new EchartsLiquidFillSample({ target: ele });
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

  function layout() {
    items = [];
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
      items.push(current);
    });
    console.log("Layout stored: " + items);
  }

  function build() {
    charts.forEach((chart, i) => {
      let id = items[i].id;
      instances[i] = getChart(id, i);
      console.log("Instances: " + instances);
    });
    gridHelp.resizeItems(items, cols);
  }

  function showConfig(id) {
    items.some((item, i) => {
      if (item.id === id) {
        hideToolBar(id);
        instances[i].showConfig();
        return true;
      }
    });
  }


</script>

<div class="container">
  {#if items !== undefined}
    <Grid
      useTransform
      {breakpoints}
      {charts}
      {cols}
      gap={10}
      bind:items
      let:item
      rowHeight={100}>
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
                  on:click={() => showConfig(item.id)}
                  title="Edit">
                  <i class="fal fa-cogs fa-fw" />
                </IconButton>
                <IconButton {ripple} class="material-icons" title="Alerts">
                  <i class="fal fa-bell fa-fw" />
                </IconButton>
                <IconButton {ripple} class="material-icons" title="Delete">
                  <i class="fal fa-trash-alt fa-fw" />
                </IconButton>
              </ActionIcons>
            </Actions>
          </div>
        </div>

      </div>
    </Grid>
  {/if}
</div>
