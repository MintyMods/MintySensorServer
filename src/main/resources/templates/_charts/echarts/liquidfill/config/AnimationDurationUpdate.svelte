<script>
  import { animationDurationUpdate } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    animationDurationUpdateText = $animationDurationUpdate;
  });

  let animationDurationUpdateText = "";
  $: if (animationDurationUpdateText) {
    $animationDurationUpdate = animationDurationUpdateText;
  }
</script>

<Textfield
  bind:value={animationDurationUpdateText}
  label="Update animation duration" />
<HelperText>value in milliseconds</HelperText>
