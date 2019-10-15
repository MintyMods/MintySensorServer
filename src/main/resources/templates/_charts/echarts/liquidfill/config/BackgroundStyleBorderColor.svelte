<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleBorderColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bsb-color-picker"),
      theme: "nano",
      default: backgroundStyleBorderColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleBorderColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (backgroundStyleBorderColor && pickr) {
    pickr.setColor(backgroundStyleBorderColor);
    dispatch("backgroundStyleBorderColor", backgroundStyleBorderColor);
  }
</script>

<style>
  .bsb-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bsb-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleBorderColor}
    label="Background border colour" />
  <div id="bsb-color-picker" />
</div>
<HelperText />
