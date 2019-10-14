<script>
  import { labelFontWeight } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const FONT_WEIGHT = ["normal", "bolder", "lighter"];

  onMount(async () => {
    await tick();
    weightSelected = $labelFontWeight;
  });

  let weightSelected;
  $: if (weightSelected) {
    $labelFontWeight = weightSelected;
  }
</script>

<Select enhanced bind:value={weightSelected} label="Label font weight">
  {#each FONT_WEIGHT as weight}
    <Option value={weight} selected={weightSelected === weight}>
      {weight}
    </Option>
  {/each}
</Select>
<HelperText />
