<script>
  import Select, { Option } from "@smui/select";
  import { labelBaseline } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import HelperText from "@smui/textfield/helper-text/index";

  const BASELINE = ["top", "middle", "bottom"];
  let labelBaselineSelected;

  onMount(async () => {
    await tick();  
    labelBaselineSelected = $labelBaseline;
  });

  $: if (labelBaselineSelected) {
    $labelBaseline = labelBaselineSelected;
  }

</script>

<Select
  enhanced
  bind:value={labelBaselineSelected}
  label="Label Baseline"
  class="labelBaseline"
  menu$class="labelBaseline">
  <Option value="" />
  {#each BASELINE as align}
    <Option value={align} selected={labelBaselineSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
  <HelperText></HelperText>