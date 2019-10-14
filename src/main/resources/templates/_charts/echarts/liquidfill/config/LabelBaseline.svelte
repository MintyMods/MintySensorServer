<script>
  import { labelBaseline } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const BASELINE = ["top", "middle", "bottom"];

  onMount(async () => {
    await tick();
    labelBaselineSelected = $labelBaseline;
  });

  let labelBaselineSelected;
  $: if (labelBaselineSelected) {
    $labelBaseline = labelBaselineSelected;
  }
</script>

<Select enhanced bind:value={labelBaselineSelected} label="Label baseline">
  {#each BASELINE as align}
    <Option value={align} selected={labelBaselineSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
<HelperText />
