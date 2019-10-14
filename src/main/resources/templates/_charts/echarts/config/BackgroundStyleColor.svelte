<script>
  import { backgroundStyleColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let backgroundStyleColorText = "";

  $: if ($backgroundStyleColor !== undefined)
    backgroundStyleColorText = $backgroundStyleColor;
  $: pickr && pickr.setColor(backgroundStyleColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("backgroundStyleColor-picker"),
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
        .toHEXA()
        .toString();
      updatebackgroundStyleColor();
    });
  }

  function updatebackgroundStyleColor() {
    pickr.setColor(backgroundStyleColorText);
    $backgroundStyleColor = backgroundStyleColorText;
  }
</script>

<style>
  .backgroundStyleColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="backgroundStyleColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleColorText}
    on:change={updatebackgroundStyleColor}
    label="Background Fill Colour" />
  <div id="backgroundStyleColor-picker" />
</div>
<HelperText />
