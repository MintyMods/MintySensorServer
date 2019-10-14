<script>
  import { outlineitemStyleColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let outlineitemStyleColorText = "";

  $: if ($outlineitemStyleColor !== undefined)
    outlineitemStyleColorText = $outlineitemStyleColor;
  $: pickr && pickr.setColor(outlineitemStyleColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("outlineitemStyleColor-picker"),
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
        .toHEXA()
        .toString();
      updateoutlineitemStyleColor();
    });
  }

  function updateoutlineitemStyleColor() {
    pickr.setColor(outlineitemStyleColorText);
    $outlineitemStyleColor = outlineitemStyleColorText;
  }
</script>

<style>
  .outlineitemStyleColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="outlineitemStyleColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleColorText}
    on:change={updateoutlineitemStyleColor}
    label="Item Style Colour" />
  <div id="outlineitemStyleColor-picker" />
</div>
<HelperText />
