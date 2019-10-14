<script>
  import { labelInsideColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    labelInsideColorText = $labelInsideColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("li-color-picker"),
      theme: "nano",
      default: labelInsideColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      labelInsideColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let labelInsideColorText = "";
  $: if (labelInsideColorText) {
    pickr.setColor(labelInsideColorText);
    $labelInsideColor = labelInsideColorText;
  }
</script>

<style>
  .li-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="li-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={labelInsideColorText}
    label="Color of text while displayed over a wave" />
  <div id="li-color-picker" />
</div>
<HelperText />
