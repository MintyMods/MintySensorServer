<script>
  
  import { createEventDispatcher } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";
    const dispatch = createEventDispatcher();
  const ALIGN = ["left", "center", "right"];
  
  export let labelAlign;
 $: if (labelAlign) {
    dispatch('labelAlign', labelAlign);
  }
</script>

<Select enhanced bind:value={labelAlign} label="Label alignment">
  {#each ALIGN as align}
    <Option value={align} selected={labelAlign === align}>
      {align}
    </Option>
  {/each}
</Select>
<HelperText />
