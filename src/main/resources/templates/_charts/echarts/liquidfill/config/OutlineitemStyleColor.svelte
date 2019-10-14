<script>
  import { outlineitemStyleColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    outlineitemStyleColorText = $outlineitemStyleColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("os-color-picker"),
      theme: "nano",
      default: outlineitemStyleColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
   });
  }

  let outlineitemStyleColorText = "";
  $: if (outlineitemStyleColorText) {
    pickr.setColor(outlineitemStyleColorText);
    $outlineitemStyleColor = outlineitemStyleColorText;
  }
</script>

<style>
  .os-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="os-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleColorText}
    label="Outline colour" />
  <div id="os-color-picker" />
</div>
<HelperText />
