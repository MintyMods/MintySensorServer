<script>
  import { animationEasing } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const EASING = [
    "linear",
    "ease",
    "ease-in",
    "ease-out",
    "ease-in-out",
    "step-start",
    "step-end"
  ];

  onMount(async () => {
    await tick();
    animationEasingSelected = $animationEasing;
  });

  let animationEasingSelected;
  $: if (animationEasingSelected) {
    $animationEasing = animationEasingSelected;
  }
</script>

<Select
  enhanced
  bind:value={animationEasingSelected}
  label="Initial Animation Easing (waves rise from bottom)">
  {#each EASING as easing}
    <Option value={easing} selected={animationEasingSelected === easing}>
      {easing}
    </Option>
  {/each}
</Select>
<HelperText>animated rising from bottom during startup</HelperText>
