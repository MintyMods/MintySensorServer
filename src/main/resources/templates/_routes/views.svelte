<script>
  import "./_scss/_views.scss";
  import ClockSpeedsBarChart from "../_samples/ClockSpeedsBarChart.svelte";
  import TempsBarChart from "../_samples/TempsBarChart.svelte";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill.svelte";
  import PowerLineChart from "../_samples/PowerLineChart.svelte";
  import JustGageSample from "../_samples/JustGageSample.svelte";
  import EchartsLiquidFillSample from "../_samples/EchartsLiquidFillSample.svelte";
  import LinearGaugeSample from "../_samples/LinearGaugeSample.svelte";
  import RadialGaugeSample from "../_samples/RadialGaugeSample.svelte";
  import Card, {Content, PrimaryAction, Media, MediaContent, Actions, ActionButtons, ActionIcons} from '@smui/card';
  import Button, {Label} from '@smui/button';
  import IconButton, {Icon} from '@smui/icon-button';
  import List, { Item, Text } from "@smui/image-list";
  import Div from "@smui/common/Div.svelte";
  import { onMount } from "svelte";

  onMount(() => {
    let pckry = new Packery( '.grid', {
      itemSelector: '.grid-item',
      gutter: 10
    });
  });

  let charts = [
    EchartsLiquidFillSample, 
    WaterTempLiquidFill ,
    ClockSpeedsBarChart,
    TempsBarChart,
    PowerLineChart,
    JustGageSample,
    LinearGaugeSample,
    RadialGaugeSample
  ];
  let ratios = [
    "square",
    "square",
    "16x9",
    "16x9",
    "16x9",
    "square",
    "square",
    "square"
  ];



</script>

{#each charts as chart, i }


<div class="grid-item">
     <Card style="width: 360px;">
        <PrimaryAction on:click={() => clicked++}>
          <Media class="card-media-16x9" aspectRatio="{ratios[i]}">
            <MediaContent>
              <svelte:component this={charts[i]}/>
            </MediaContent>
          </Media>
        </PrimaryAction>
        <Actions>
          <ActionIcons>
            <IconButton class="material-icons" on:click={() => clicked++} title="Edit"><i class="fal fa-cogs"></i></IconButton>
            <IconButton class="material-icons" on:click={() => clicked++} title="Delete"><i class="fal fa-trash-alt"></i></IconButton>
          <IconButton class="material-icons" on:click={() => clicked++} title="About"><i class="fal fa-info-circle"></i></IconButton>
          </ActionIcons>
        </Actions>
      </Card>
</div>
{/each}

