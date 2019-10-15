<script>
  import { createEventDispatcher } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  const POSTITION = ["inside", "left", "right", "top", "bottom"];

  export let labelPosition;
  $: if (labelPosition) {
    dispatch("labelPosition", labelPosition);
  }
</script>

<Select enhanced bind:value={labelPosition} label="Label position">
  {#each POSTITION as align}
    <Option value={align} selected={labelPosition === align}>{align}</Option>
  {/each}
</Select>
<HelperText />
