<script>
  import { backgroundStyleBorderColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    backgroundStyleBorderColorText = $backgroundStyleBorderColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bsb-color-picker"),
      theme: "nano",
      default: backgroundStyleBorderColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleBorderColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let backgroundStyleBorderColorText = "";
  $: if (backgroundStyleBorderColorText) {
    pickr.setColor(backgroundStyleBorderColorText);
    $backgroundStyleBorderColor = backgroundStyleBorderColorText;
  }
</script>

<style>
  .bsb-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bsb-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleBorderColorText}
    label="Background border colour" />
  <div id="bsb-color-picker" />
</div>
<HelperText />
