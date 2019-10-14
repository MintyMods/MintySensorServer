<script>
  import "./_scss/_views.scss";
  import { onMount, tick, beforeUpdate } from "svelte";
  import { fade } from "svelte/transition";
  import Grid from "svelte-grid";
  import gridHelp from "svelte-grid/build/helper/index.mjs";
  import Card, { Actions, ActionButtons, ActionIcons } from "@smui/card";
  import IconButton, { Icon } from "@smui/icon-button";
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart.svelte";
  import JustGageSample2 from "../_samples/JustGageSample2.svelte";
  import TempsBarChart from "../_samples/TempsBarChart.svelte";
  import PowerLineChart from "../_samples/PowerLineChart.svelte";
  import JustGageSample1 from "../_samples/JustGageSample1.svelte";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample.svelte";
  import LinearGaugeSample from "../_samples/LinearGaugeSample.svelte";
  import JustGageSample3 from "../_samples/JustGageSample3.svelte";
  import RadialGaugeSample from "../_samples/RadialGaugeSample.svelte";

  export let ripple = false;
  let adjustAfterRemove = true;

  let charts = [
    JustGageSample2,
    EchartsLiquidFillSample,
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
          return new JustGageSample2({ target: ele });
        case 1:
          return new EchartsLiquidFillSample({ target: ele });
        case 2:
          return new ClockSpeedsBarChart({ target: ele });
        case 3:
          return new TempsBarChart({ target: ele });
        case 4:
          return new JustGageSample1({ target: ele });
        case 5:
          return new PowerLineChart({ target: ele });
        case 6:
          return new LinearGaugeSample({ target: ele });
        case 7:
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
    items = gridHelp.resizeItems(layout, cols);
  }

  function buildCharts() {
    charts.forEach((chart, i) => {
      let id = items[i].id;
      instances[i] = getChart(id, i);
    });
    gridHelp.resizeItems(items, cols);
  }

  function showConfig(layout) {
    // expandContainer(id);
    items.some((item, i) => {
      if (item.id === layout.id) {
        hideToolBar(layout.id);
        instances[i].showConfig(item);
        return true;
      }
    });
  }

  function showConfirm(item) {
    let toolbar = document.getElementById("toolbar-" + item.id);
    let confirm = document.getElementById("confirm-" + item.id);
    confirm.classList.add("confirm-active");
    toolbar.style.display = "none";
    confirm.style.display = "block";
  }

  function hideConfirm(item) {
    let toolbar = document.getElementById("toolbar-" + item.id);
    let confirm = document.getElementById("confirm-" + item.id);
    confirm.classList.remove("confirm-active");
    toolbar.style.display = "block";
    confirm.style.display = "none";
  }

  function removeContainer(item) {
    items = items.filter(value => value.id !== item.id);
    if (adjustAfterRemove) {
      items = gridHelp.resizeItems(items, cols);
    }
  }
  async function pinItemContainer(item) {
    item.static = !item.static;
    await tick();
    items = gridHelp.resizeItems(items, cols);
  }

  function expandContainer(id) {
    let wrapper = document.getElementById(id);
  }
</script>

<div class="container">
  {#if items !== undefined}
    <Grid
      {breakpoints}
      {charts}
      {cols}
      gap={5}
      rowHeight={100}
      fillEmpty={true}
      useTransform={false}
      static={true}
      bind:items
      let:item>
      <div
        out:fade={{ duration: 300 }}
        id={item.id}
        class="content"
        style="background: {item.static ? '#ccccee' : item.data}"
        on:mouseenter={() => showToolBar(item.id)}
        on:mouseleave={() => hideToolBar(item.id)}>
        <div class="toolbar-wrapper">
          <Actions>
            <ActionIcons>
              <div id={'toolbar-' + item.id} class:hover class="toolbar">
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
                  on:click={() => showConfirm(item, this)}>
                  <i class="fal fa-trash-alt fa-fw" />
                </IconButton>
                <IconButton
                  {ripple}
                  class="material-icons primary"
                  title="Pin"
                  on:click={() => pinItemContainer(item)}>
                  <i class="fal fa-thumbtack fa-fw" />
                </IconButton>
              </div>
              <div id={'confirm-' + item.id} class:hover class="confirm">
                <div>Remove</div>
                <IconButton
                  {ripple}
                  class="material-icons"
                  title="Cancel"
                  on:click={() => hideConfirm(item, this)}>
                  <i class="fal fa-times fa-fw" />
                </IconButton>
                <IconButton
                  {ripple}
                  class="material-icons primary"
                  title="Pin"
                  on:click={() => removeContainer(item)}>
                  <i class="fal fa-check fa-fw" />
                </IconButton>
              </div>
            </ActionIcons>
          </Actions>
        </div>

      </div>
    </Grid>
  {/if}
</div>
