<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleItemStyleShadowColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bss-color-picker"),
      theme: "nano",
      default: backgroundStyleItemStyleShadowColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleItemStyleShadowColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (backgroundStyleItemStyleShadowColor && pickr) {
    pickr.setColor(backgroundStyleItemStyleShadowColor);
    dispatch(
      "backgroundStyleItemStyleShadowColor",
      backgroundStyleItemStyleShadowColor
    );
  }
</script>

<style>
  .bss-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bss-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleItemStyleShadowColor}
    label="Background shadow colour" />
  <div id="bss-color-picker" />
</div>
<HelperText />
