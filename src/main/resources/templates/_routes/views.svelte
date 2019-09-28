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
  import Card, {
    Content,
    PrimaryAction,
    Media,
    MediaContent,
    Actions,
    ActionButtons,
    ActionIcons
  } from "@smui/card";

  import Button, { Label } from "@smui/button";
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
  const id = () =>
    "_" +
    Math.random()
      .toString(36)
      .substr(2, 9);

  onMount(async () => {
    await tick();
    layout();
    await tick();
    build();
  });

  function showToolBar(i) {
    document.getElementById("toolbar-" + i).classList.add("toolbar-active");
  }
  function hideToolBar(i) {
    document.getElementById("toolbar-" + i).classList.remove("toolbar-active");
  }

  function showConfig(i) {
    hideToolBar(i);
    instances[i].showConfig();
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
        id: chart.name
      });
      items.push(current);
    });
    // items = gridHelp.resizeItems(items, cols);
  }

  function build() {
    charts.forEach((chart, i) => {
      instances[chart.name] = getChart(chart.name, chart.name);
      console.log(instances[chart.name]);
    });
    gridHelp.resizeItems(items, cols);
  }

  function getChart(type, target) {
    let ele = document.getElementById(target);
    if (ele !== null) {
      switch (type) {
        case "WaterTempLiquidFill":
          return new WaterTempLiquidFill({ target: ele });
        case "EchartsLiquidFillSample":
          return new EchartsLiquidFillSample({ target: ele });
        case "JustGageSample2":
          return new JustGageSample2({ target: ele });
        case "ClockSpeedsBarChart":
          return new ClockSpeedsBarChart({ target: ele });
        case "TempsBarChart":
          return new TempsBarChart({ target: ele });
        case "JustGageSample1":
          return new JustGageSample1({ target: ele });
        case "PowerLineChart":
          return new PowerLineChart({ target: ele });
        case "LinearGaugeSample":
          return new LinearGaugeSample({ target: ele });
        case "JustGageSample3":
          return new JustGageSample3({ target: ele });
        case "RadialGaugeSample":
          return new RadialGaugeSample({ target: ele });
      }
    }
  }
</script>

<style>

</style>

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
        style="background: {item.static ? '#ccccee' : item.data}" />
    </Grid>
  {/if}
</div>
<!-- <Card
        style="width: 360px; position:relative;"
        on:mouseenter={() => showToolBar(item.id)}
        on:mouseleave={() => hideToolBar(item.id)}>
        <div class="wrapper">
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
                <IconButton
                  {ripple}
                  on:click={() => process('NOTIFICATIONS')}
                  class="material-icons"
                  title="Alerts">
                  <i class="fal fa-bell fa-fw" />
                </IconButton>
                <IconButton
                  {ripple}
                  class="material-icons"
                  on:click={() => process('DELETE')}
                  title="Delete">
                  <i class="fal fa-trash-alt fa-fw" />
                </IconButton>
              </ActionIcons>
            </Actions>
          </div>
        </div>
        <Media class="card-media-16x9" {aspectRatio}>
          <MediaContent>
            <svelte:component
              this={charts[item.id]}
              bind:this={instances[item.id]} />
          </MediaContent>
        </Media>
      </Card> -->
