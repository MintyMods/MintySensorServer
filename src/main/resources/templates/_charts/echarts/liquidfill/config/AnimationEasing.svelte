<script>
  import { createEventDispatcher } from "svelte";
  import { EASING } from "./constants.js";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

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
    <Option value={easing.type} selected={easing.type === animationEasing}>{easing.desc}</Option>
  {/each}
</Select>
<HelperText>animated rising from bottom during startup</HelperText>
