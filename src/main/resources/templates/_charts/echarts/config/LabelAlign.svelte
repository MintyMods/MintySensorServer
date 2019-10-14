<script>
  import Select, { Option } from "@smui/select";
  import { labelAlign } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import HelperText from "@smui/textfield/helper-text/index";

  const ALIGN = ["left", "center", "right"];
  let labelAlignSelected;

  onMount(async () => {
    await tick();  
    labelAlignSelected = $labelAlign;
  });

  $: if (labelAlignSelected) {
    $labelAlign = labelAlignSelected;
  }

</script>

<Select
  enhanced
  bind:value={labelAlignSelected}
  label="Label Alignment"
  class="labelAlign"
  menu$class="labelAlign">
  <Option value="" />
  {#each ALIGN as align}
    <Option value={align} selected={labelAlignSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
  <HelperText></HelperText>