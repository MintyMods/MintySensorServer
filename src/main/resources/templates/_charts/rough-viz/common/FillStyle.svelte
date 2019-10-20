<script>
  import { createEventDispatcher } from "svelte";
  import { FILL_STYLE } from "./constants.js";
  import Select, { Option } from "@smui/select";
  
  export let fillStyle;
  const dispatch = createEventDispatcher();

  $: if (fillStyle) {
    dispatch("fillStyle", fillStyle);
  }
</script>

<Select enhanced bind:value={fillStyle} label="Fill style">
  {#each FILL_STYLE as style}
    <Option value={style.type} selected={style.type === fillStyle}>{style.desc}</Option>
  {/each}
</Select>
