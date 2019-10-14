<script>
  import { animationDurationUpdate } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let animationDurationUpdateText = "";

  onMount(async () => {
    await tick();
    animationDurationUpdateText = $animationDurationUpdate;
  });

  function update() {
    $animationDurationUpdate = animationDurationUpdateText;
  }
</script>

<Textfield on:change={update} bind:value={animationDurationUpdateText} label="Update Animation Duration" />
<HelperText>Value in milliseconds</HelperText>