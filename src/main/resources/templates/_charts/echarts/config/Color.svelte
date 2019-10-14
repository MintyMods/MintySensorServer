<script>
  import { color } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let colorText = "";

  $: if ($color !== undefined) colorText = $color;
  $: pickr && pickr.setColor(colorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("color-picker"),
      theme: "nano",
      default: colorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      colorText = instance
        .getColor()
        .toHEXA()
        .toString();
      updateColor();
    });
  }

  function updateColor() {
    pickr.setColor(colorText);
    $color = colorText;
  }
</script>

<style>
  .color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={colorText}
    on:change={updateColor}
    label="Wave Colour" />
  <div id="color-picker" />
</div>
<HelperText />
