<script>
  import { backgroundStyleColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    backgroundStyleColorText = $backgroundStyleColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bs-color-picker"),
      theme: "nano",
      default: backgroundStyleColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let backgroundStyleColorText = "";
  $: if (backgroundStyleColorText) {
    pickr.setColor(backgroundStyleColorText);
    $backgroundStyleColor = backgroundStyleColorText;
  }
</script>

<style>
  .bs-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bs-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleColorText}
    label="Background fill colour" />
  <div id="bs-color-picker" />
</div>
<HelperText />
