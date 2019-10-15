<script>
  import { createEventDispatcher } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";
  import { EASING } from "./constants.js";

  const dispatch = createEventDispatcher();
  export let animationEasing;

  $: if (animationEasing) {
    dispatch("animationEasing", animationEasing);
  }
</script>

<Select
  enhanced
  bind:value={animationEasing}
  label="Initial Animation Easing (waves rise from bottom)">
  {#each EASING as easing}
    <Option value={easing} selected={animationEasing === easing}>
      {easing}
    </Option>
  {/each}
</Select>
<HelperText>animated rising from bottom during startup</HelperText>
