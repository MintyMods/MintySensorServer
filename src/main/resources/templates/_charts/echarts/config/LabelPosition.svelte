<script>
  import Select, { Option } from "@smui/select";
  import { labelPosition } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import HelperText from "@smui/textfield/helper-text/index";

  const POSTITION = ["inside", "left", "right", "top", "bottom"];
  let labelPositionSelected;

  onMount(async () => {
    await tick();  
    labelPositionSelected = $labelPosition;
  });

  $: if (labelPositionSelected) {
    $labelPosition = labelPositionSelected;
  }

</script>

<Select
  enhanced
  bind:value={labelPositionSelected}
  label="Label Position"
  class="labelPosition"
  menu$class="labelPosition">
  <Option value="" />
  {#each POSTITION as align}
    <Option value={align} selected={labelPositionSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
  <HelperText></HelperText>