<script>
  import Select, { Option } from "@smui/select";
  import { animationEasingUpdate } from "./echarts-liquid-fill-store.js";
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

  let animationEasingUpdateSelected;

  onMount(async () => {
    await tick();
    animationEasingUpdateSelected = $animationEasingUpdate;
  });

  $: if (animationEasingUpdateSelected) {
    $animationEasingUpdate = animationEasingUpdateSelected;
  }
</script>

<Select
  enhanced
  bind:value={animationEasingUpdateSelected}
  label="Animation Easing Update (value & position changes)"
  class="animationEasingUpdate"
  menu$class="animationEasingUpdate">
  <Option value="" />
  {#each EASING as easing}
    <Option value={easing} selected={animationEasingUpdateSelected === easing}>
      {easing}
    </Option>
  {/each}
</Select>
  <HelperText>Chart value & position changes</HelperText>