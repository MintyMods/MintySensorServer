<script>
  import { animationDuration } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    animationDurationText = $animationDuration;
  });

  let animationDurationText = "";
  $: if (animationDurationText) {
    $animationDuration = animationDurationText;
  }
</script>

<Textfield
  bind:value={animationDurationText}
  label="Initial animation duration" />
<HelperText>value in milliseconds</HelperText>
