<script>
  import { labelAlign } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Select, { Option } from "@smui/select";
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

<Select enhanced bind:value={labelAlignSelected} label="Label alignment">
  {#each ALIGN as align}
    <Option value={align} selected={labelAlignSelected === align}>
      {align}
    </Option>
  {/each}
</Select>
<HelperText />
