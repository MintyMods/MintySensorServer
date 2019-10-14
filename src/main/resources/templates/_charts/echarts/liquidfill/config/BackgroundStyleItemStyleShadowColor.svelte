<script>
  import { backgroundStyleItemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    backgroundStyleItemStyleShadowColorText = $backgroundStyleItemStyleShadowColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bss-color-picker"),
      theme: "nano",
      default: backgroundStyleItemStyleShadowColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleItemStyleShadowColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let backgroundStyleItemStyleShadowColorText = "";
  $: if (backgroundStyleItemStyleShadowColorText) {
    pickr.setColor(backgroundStyleItemStyleShadowColorText);
    $backgroundStyleItemStyleShadowColor = backgroundStyleItemStyleShadowColorText;
  }
</script>

<style>
  .bss-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bss-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleItemStyleShadowColorText}
    label="Background shadow colour" />
  <div id="bss-color-picker" />
</div>
<HelperText />
