<script>
  import { labelColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let labelColorText = "";

  $: if ($labelColor !== undefined)
    labelColorText = $labelColor;
  $: pickr && pickr.setColor(labelColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("labelColor-picker"),
      theme: "nano",
      default: labelColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      labelColorText = instance
        .getColor()
        .toHEXA()
        .toString();
      updatelabelColor();
    });
  }

  function updatelabelColor() {
    pickr.setColor(labelColorText);
    $labelColor = labelColorText;
  }
</script>

<style>
  .labelColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="labelColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={labelColorText}
    on:change={updatelabelColor}
    label="Color of text when displayed on background" />
  <div id="labelColor-picker" />
</div>
<HelperText />
