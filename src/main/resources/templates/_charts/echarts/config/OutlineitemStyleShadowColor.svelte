<script>
  import { outlineitemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let outlineitemStyleShadowColorText = "";

  $: if ($outlineitemStyleShadowColor !== undefined)
    outlineitemStyleShadowColorText = $outlineitemStyleShadowColor;
  $: pickr && pickr.setColor(outlineitemStyleShadowColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("outlineitemStyleShadowColor-picker"),
      theme: "nano",
      default: outlineitemStyleShadowColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleShadowColorText = instance
        .getColor()
        .toHEXA()
        .toString();
      updateoutlineitemStyleShadowColor();
    });
  }

  function updateoutlineitemStyleShadowColor() {
    pickr.setColor(outlineitemStyleShadowColorText);
    $outlineitemStyleShadowColor = outlineitemStyleShadowColorText;
  }
</script>

<style>
  .outlineitemStyleShadowColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="outlineitemStyleShadowColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleShadowColorText}
    on:change={updateoutlineitemStyleShadowColor}
    label="Outline Shadow Colour" />
  <div id="outlineitemStyleShadowColor-picker" />
</div>
<HelperText />