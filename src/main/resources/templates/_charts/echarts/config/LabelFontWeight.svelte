<script>
  import Select, { Option } from "@smui/select";
  import { labelFontWeight } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import HelperText from "@smui/textfield/helper-text/index";

  const FONT_WEIGHT = ["normal", "bold", "bolder", "lighter"];

  let weightSelected;

  onMount(async () => {
    await tick();  
    weightSelected = $labelFontWeight;
  });

  $: if (weightSelected) {
    $labelFontWeight = weightSelected;
  }

</script>

<Select
  enhanced
  bind:value={weightSelected}
  label="Label Font Weight"
  class="weight"
  menu$class="weight">
  <Option value="" />
  {#each FONT_WEIGHT as weight}
    <Option value={weight} selected={weightSelected === weight}>
      {weight}
    </Option>
  {/each}
</Select>
  <HelperText></HelperText>