<script>
  import { animationDuration } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let animationDurationText = "";

  onMount(async () => {
    await tick();
    animationDurationText = $animationDuration;
  });

  function update() {
    $animationDuration = animationDurationText;
  }
</script>

<Textfield on:change={update} bind:value={animationDurationText} label="Initial Animation Duration" />
<HelperText>Value in milliseconds</HelperText>