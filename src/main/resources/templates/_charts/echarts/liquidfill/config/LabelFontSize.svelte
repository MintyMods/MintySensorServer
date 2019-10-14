<script>
  import { labelFontSize } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    labelFontSizeText = $labelFontSize;
  });

  let labelFontSizeText = "";
  $: if (labelFontSizeText) {
    $labelFontSize = labelFontSizeText;
  }
</script>

<Textfield bind:value={labelFontSizeText} label="Label font size" />
<HelperText />
