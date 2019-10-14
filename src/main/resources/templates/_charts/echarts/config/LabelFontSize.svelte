<script>
  import { labelFontSize } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let labelFontSizeText = "";

  onMount(async () => {
    await tick();
    labelFontSizeText = $labelFontSize;
  });

  function update() {
    $labelFontSize = labelFontSizeText;
  }
</script>

<Textfield on:change={update} bind:value={labelFontSizeText} label="Label font size" />
<HelperText>Value in pixels 'px', 'em', 'rem', '%', etc.</HelperText>