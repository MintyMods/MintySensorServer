<script>
  import { itemStyleShadowColor } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    itemStyleShadowColorText = $itemStyleShadowColor;
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("iss-color-picker"),
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
        .toRGBA()
        .toString(2);
   });
  }

  let itemStyleShadowColorText = "";
  $: if (itemStyleShadowColorText) {
    pickr.setColor(itemStyleShadowColorText);
    $itemStyleShadowColor = itemStyleShadowColorText;
  }
</script>

<style>
  .iss-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="iss-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={itemStyleShadowColorText}
    label="Wave shadow colour" />
  <div id="iss-color-picker" />
</div>
<HelperText />
