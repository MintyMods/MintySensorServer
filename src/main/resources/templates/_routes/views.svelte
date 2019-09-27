<script>
  import "./_scss/_views.scss";
  import Notification from "../_components/Notification";
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
  import List, { Item, Text } from "@smui/image-list";
  import Div from "@smui/common/Div.svelte";
  import { onMount } from "svelte";
  import ChartCard from "../_components/ChartCard";

  export let aspectRatio = "square";
  export let ripple = false;
  let hover = false;

  onMount(() => {
    pckry = new Packery(".grid", {
      itemSelector: ".grid-item",
      gutter: 10
    });
  });

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
  let instances = [];

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

  let pckry;
</script>

{#each charts as chart, i}

  <div class="grid-item">
    <Card
      style="width: 360px; position:relative;"
      on:mouseenter={() => showToolBar(i)}
      on:mouseleave={() => hideToolBar(i)}>
      <div class="wrapper">
        <!-- <div id="toolbar" class:hover class="toolbar"> -->
        <div id={'toolbar-' + i} class:hover class="toolbar">
          <Actions>
            <ActionIcons>
              <IconButton
                {ripple}
                class="material-icons"
                on:click={() => showConfig(i)}
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
          <svelte:component this={charts[i]} bind:this={instances[i]} />
        </MediaContent>
      </Media>
    </Card>
  </div>
{/each}
