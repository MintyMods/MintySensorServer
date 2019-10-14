<script>
  import { backgroundStyleItemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let backgroundStyleItemStyleShadowColorText = "";

  $: if ($backgroundStyleItemStyleShadowColor !== undefined)
    backgroundStyleItemStyleShadowColorText = $backgroundStyleItemStyleShadowColor;
  $: pickr && pickr.setColor(backgroundStyleItemStyleShadowColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("backgroundStyleItemStyleShadowColor-picker"),
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
        .toHEXA()
        .toString();
      updatebackgroundStyleItemStyleShadowColor();
    });
  }

  function updatebackgroundStyleItemStyleShadowColor() {
    pickr.setColor(backgroundStyleItemStyleShadowColorText);
    $backgroundStyleItemStyleShadowColor = backgroundStyleItemStyleShadowColorText;
  }
</script>

<style>
  .backgroundStyleItemStyleShadowColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="backgroundStyleItemStyleShadowColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleItemStyleShadowColorText}
    on:change={updatebackgroundStyleItemStyleShadowColor}
    label="Background Shadow Colour" />
  <div id="backgroundStyleItemStyleShadowColor-picker" />
</div>
<HelperText />