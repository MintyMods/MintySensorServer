<script>
  import { itemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  let pickr;
  let itemStyleShadowColorText = "";

  $: if ($itemStyleShadowColor !== undefined)
    itemStyleShadowColorText = $itemStyleShadowColor;
  $: pickr && pickr.setColor(itemStyleShadowColorText);

  onMount(async () => {
    await tick();
    initPickr();
  });

  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("itemStyleShadowColor-picker"),
      theme: "nano",
      default: itemStyleShadowColorText,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      itemStyleShadowColorText = instance
        .getColor()
        .toHEXA()
        .toString();
      updateitemStyleShadowColor();
    });
  }

  function updateitemStyleShadowColor() {
    pickr.setColor(itemStyleShadowColorText);
    $itemStyleShadowColor = itemStyleShadowColorText;
  }
</script>

<style>
  .itemStyleShadowColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="itemStyleShadowColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={itemStyleShadowColorText}
    on:change={updateitemStyleShadowColor}
    label="Wave Shadow Colour" />
  <div id="itemStyleShadowColor-picker" />
</div>
<HelperText />
