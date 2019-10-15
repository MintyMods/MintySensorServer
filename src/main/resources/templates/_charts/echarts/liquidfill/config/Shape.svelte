<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import { SHAPES } from "./constants.js";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();

  export let shape;
  $: if (shape) {
    dispatch("shape", shape);
  }
</script>

<Select enhanced bind:value={shape} label="Gauge shape">
  {#each SHAPES as option}
    <Option value={option.type} selected={shape === option.type}>
      <i class={option.icon} />
      {option.desc}
    </Option>
  {/each}
</Select>
<HelperText />
