<script>
  import { outlineitemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    outlineitemStyleShadowColorText = $outlineitemStyleShadowColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("oss-color-picker"),
      theme: "nano",
      default: outlineitemStyleShadowColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleShadowColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let outlineitemStyleShadowColorText = "";
  $: if (outlineitemStyleShadowColorText) {
    pickr.setColor(outlineitemStyleShadowColorText);
    $outlineitemStyleShadowColor = outlineitemStyleShadowColorText;
  }
</script>

<style>
  .oss-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="oss-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleShadowColorText}
    label="Outline shadow colour" />
  <div id="oss-color-picker" />
</div>
<HelperText />
