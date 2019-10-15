<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";
  const dispatch = createEventDispatcher();

  export let itemStyleShadowColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("iss-color-picker"),
      theme: "nano",
      default: itemStyleShadowColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      itemStyleShadowColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (itemStyleShadowColor && pickr) {
    pickr.setColor(itemStyleShadowColor);
    dispatch("itemStyleShadowColor", itemStyleShadowColor);
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
    bind:value={itemStyleShadowColor}
    label="Wave shadow colour" />
  <div id="iss-color-picker" />
</div>
<HelperText />
