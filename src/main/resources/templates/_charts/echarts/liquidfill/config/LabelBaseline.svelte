<script>
  import { createEventDispatcher } from "svelte";
 import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";
  import { BASELINE } from "./constants.js";

  const dispatch = createEventDispatcher();
  export let labelBaseline;

  $: if (labelBaseline) {
    dispatch("labelBaseline", labelBaseline);
  }
</script>

<Select enhanced bind:value={labelBaseline} label="Label baseline">
  {#each BASELINE as align}
    <Option value={align} selected={align === labelBaseline}>{align}</Option>
  {/each}
</Select>
<HelperText />
