<script>
  import { outlineitemStyleBorderColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    outlineitemStyleBorderColorText = $outlineitemStyleBorderColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("osb-color-picker"),
      theme: "nano",
      default: outlineitemStyleBorderColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleBorderColorText = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  let outlineitemStyleBorderColorText = "";
  $: if (outlineitemStyleBorderColorText) {
    pickr.setColor(outlineitemStyleBorderColorText);
    $outlineitemStyleBorderColor = outlineitemStyleBorderColorText;
  }
</script>

<style>
  .osb-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="osb-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleBorderColorText}
    label="Outline border colour" />
  <div id="osb-color-picker" />
</div>
<HelperText />
