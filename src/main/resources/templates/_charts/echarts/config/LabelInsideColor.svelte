<script>
  import { labelInsideColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let labelInsideColorText = "";

  $: if ($labelInsideColor !== undefined)
    labelInsideColorText = $labelInsideColor;
  $: pickr && pickr.setColor(labelInsideColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("labelInsideColor-picker"),
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
        .toHEXA()
        .toString();
      updatelabelInsideColor();
    });
  }

  function updatelabelInsideColor() {
    pickr.setColor(labelInsideColorText);
    $labelInsideColor = labelInsideColorText;
  }
</script>

<style>
  .labelInsideColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="labelInsideColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={labelInsideColorText}
    on:change={updatelabelInsideColor}
    label="Color of text when displayed on wave" />
  <div id="labelInsideColor-picker" />
</div>
<HelperText />
