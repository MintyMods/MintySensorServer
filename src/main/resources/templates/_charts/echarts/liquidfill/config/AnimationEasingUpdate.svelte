<script>
  import { animationEasingUpdate } from "./echarts-liquid-fill-store.js";
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
    animationEasingUpdateSelected = $animationEasingUpdate;
  });

  let animationEasingUpdateSelected;
  $: if (animationEasingUpdateSelected) {
    $animationEasingUpdate = animationEasingUpdateSelected;
  }
</script>

<Select
  enhanced
  bind:value={animationEasingUpdateSelected}
  label="Animation Easing Update (value & position changes)">
  {#each EASING as easing}
    <Option value={easing} selected={animationEasingUpdateSelected === easing}>
      {easing}
    </Option>
  {/each}
</Select>
<HelperText>chart value & position changes</HelperText>
