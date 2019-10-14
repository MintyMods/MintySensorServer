<script>
  import { backgroundStyleBorderColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let backgroundStyleBorderColorText = "";

  $: if ($backgroundStyleBorderColor !== undefined)
    backgroundStyleBorderColorText = $backgroundStyleBorderColor;
  $: pickr && pickr.setColor(backgroundStyleBorderColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("backgroundStyleBorderColor-picker"),
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
        .toHEXA()
        .toString();
      updatebackgroundStyleBorderColor();
    });
  }

  function updatebackgroundStyleBorderColor() {
    pickr.setColor(backgroundStyleBorderColorText);
    $backgroundStyleBorderColor = backgroundStyleBorderColorText;
  }
</script>

<style>
  .backgroundStyleBorderColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="backgroundStyleBorderColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleBorderColorText}
    on:change={updatebackgroundStyleBorderColor}
    label="Background Border Colour" />
  <div id="backgroundStyleBorderColor-picker" />
</div>
<HelperText />
