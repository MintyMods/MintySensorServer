<script>
  import { outlineitemStyleBorderColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let outlineitemStyleBorderColorText = "";

  $: if ($outlineitemStyleBorderColor !== undefined)
    outlineitemStyleBorderColorText = $outlineitemStyleBorderColor;
  $: pickr && pickr.setColor(outlineitemStyleBorderColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("outlineitemStyleBorderColor-picker"),
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
        .toHEXA()
        .toString();
      updateoutlineitemStyleBorderColor();
    });
  }

  function updateoutlineitemStyleBorderColor() {
    pickr.setColor(outlineitemStyleBorderColorText);
    $outlineitemStyleBorderColor = outlineitemStyleBorderColorText;
  }
</script>

<style>
  .outlineitemStyleBorderColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="outlineitemStyleBorderColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleBorderColorText}
    on:change={updateoutlineitemStyleBorderColor}
    label="Item Style Border Colour" />
  <div id="outlineitemStyleBorderColor-picker" />
</div>
<HelperText />
