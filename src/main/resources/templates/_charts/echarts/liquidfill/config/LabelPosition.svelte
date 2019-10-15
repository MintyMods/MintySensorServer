<script>
  import { createEventDispatcher } from "svelte";
  import { POSITION } from "./constants.js";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";
  const dispatch = createEventDispatcher();
  export let labelPosition;

  $: if (labelPosition) {
    dispatch("labelPosition", labelPosition);
  }
</script>

<Select enhanced bind:value={labelPosition} label="Label position">
  {#each POSITION as align}
    <Option value={align} selected={align === labelPosition}>{align}</Option>
  {/each}
</Select>
<HelperText />
