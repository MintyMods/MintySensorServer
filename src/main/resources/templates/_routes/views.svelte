<script>
  import "./_scss/_views.scss";
  import Notification from "../_components/Notification.svelte";
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart.svelte";
  import JustGageSample2 from "../_samples/JustGageSample2.svelte";
  import TempsBarChart from "../_samples/TempsBarChart.svelte";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill.svelte";
  import PowerLineChart from "../_samples/PowerLineChart.svelte";
  import JustGageSample1 from "../_samples/JustGageSample1.svelte";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample.svelte";
  import LinearGaugeSample from "../_samples/LinearGaugeSample.svelte";
  import JustGageSample3 from "../_samples/JustGageSample3.svelte";
  import RadialGaugeSample from "../_samples/RadialGaugeSample.svelte";
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
  import List, { Item, Text } from "@smui/image-list";
  import Div from "@smui/common/Div.svelte";
  import { onMount } from "svelte";

  onMount(() => {
    pckry = new Packery(".grid", {
      itemSelector: ".grid-item",
      gutter: 10
    });
  });

  let charts = [
    EchartsLiquidFillSample,
    JustGageSample2,
    WaterTempLiquidFill,
    ClockSpeedsBarChart,
    TempsBarChart,
    JustGageSample1,
    PowerLineChart,
    LinearGaugeSample,
    JustGageSample3,
    RadialGaugeSample
  ];
  let ratios = [
    "square",
    "16x9",
    "16x9",
    "16x9",
    "16x9",
    "square",
    "square",
    "square",
    "square",
    "square"
  ];
  let clicked;
  let edit;
  let pckry;
  //$: edit;

  function showToolBar(i) {
    document.getElementById("toolbar-" + i).classList.add("toolbar-active");
  }
  function hideToolBar(i) {
    document.getElementById("toolbar-" + i).classList.remove("toolbar-active");
  }
$:console.log("**Edit:" + edit);

</script>

{#each charts as chart, i}
  <div class="grid-item">
    <Card
      style="width: 360px; position:relative;"
      on:mouseenter={() => showToolBar(i)}
      on:mouseleave={() => hideToolBar(i)}>
      <div class="wrapper">
        <div id={'toolbar-' + i} class="toolbar">
          <Actions>
            <ActionIcons>
              <IconButton
                ripple={false}
                class="material-icons"
                on:click={() => chart.open()}
                title="Edit">
                <i class="fal fa-cogs fa-fw" />
              </IconButton>
              <IconButton
                ripple={false}
                class="material-icons"

                title="Alerts">
                <i class="fal fa-bell fa-fw" />
              </IconButton>
              <IconButton
                ripple={false}
                class="material-icons"
                on:click={() => document.body.focus()}
                title="Delete">
                <i class="fal fa-trash-alt fa-fw" />
              </IconButton>
            </ActionIcons>
          </Actions>
        </div>
      </div>
      <Media class="card-media-16x9" aspectRatio={ratios[i]}>
        <MediaContent>
          <svelte:component this={charts[i]} {edit}/>
        </MediaContent>
      </Media>
    </Card>
  </div>
{/each}
