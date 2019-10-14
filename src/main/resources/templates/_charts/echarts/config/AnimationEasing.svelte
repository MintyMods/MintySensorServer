<script>
  import Select, { Option } from "@smui/select";
  import { animationEasing } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
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

  let animationEasingSelected;

  onMount(async () => {
    await tick();
    animationEasingSelected = $animationEasing;
  });

  $: if (animationEasingSelected) {
    $animationEasing = animationEasingSelected;
  }
</script>
<Select
  enhanced
  bind:value={animationEasingSelected}
  label="Initial Animation Easing (waves raise from bottom)"
  class="animationEasing"
  menu$class="animationEasing">
  <Option value="" />
  {#each EASING as easing}
    <Option value={easing} selected={animationEasingSelected === easing}>
      {easing}
    </Option>
  {/each}
</Select>
  <HelperText>Start animation raising from bottom</HelperText>
