<script>
  import { createEventDispatcher } from "svelte";
  import { ALIGN } from "./constants.js";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let labelAlign;

  $: if (labelAlign) {
    dispatch("labelAlign", labelAlign);
  }
</script>

<Select enhanced bind:value={labelAlign} label="Label alignment">
  {#each ALIGN as align}
    <Option value={align} selected={align === labelAlign}>{align}</Option>
  {/each}
</Select>
<HelperText />
