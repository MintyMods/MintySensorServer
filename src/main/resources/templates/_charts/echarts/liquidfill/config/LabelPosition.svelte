<script>
  import { labelPosition } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const POSTITION = ["inside", "left", "right", "top", "bottom"];

  onMount(async () => {
    await tick();
    labelPositionSelected = $labelPosition;
  });

  let labelPositionSelected;
  $: if (labelPositionSelected) {
    $labelPosition = labelPositionSelected;
  }
</script>

<Select enhanced bind:value={labelPositionSelected} label="Label position">
  {#each POSTITION as align}
    <Option value={align} selected={labelPositionSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
<HelperText />
