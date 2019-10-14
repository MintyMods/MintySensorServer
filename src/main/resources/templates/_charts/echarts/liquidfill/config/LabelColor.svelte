<script>
  import { labelColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    labelColorText = $labelColor;
    initPickr();
  });

  let pickr;
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
        .toRGBA()
        .toString(2);
    });
  }

  let labelColorText = "";
  $: if (labelColorText) {
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
    label="Color of text when displayed on background" />
  <div id="labelColor-picker" />
</div>
<HelperText />
