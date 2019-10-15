<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

    const dispatch = createEventDispatcher();
  export let outlineitemStyleBorderColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("osb-color-picker"),
      theme: "nano",
      default: outlineitemStyleBorderColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleBorderColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (outlineitemStyleBorderColor && pickr) {
    pickr.setColor(outlineitemStyleBorderColor);
    dispatch('outlineitemStyleBorderColor', outlineitemStyleBorderColor);
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
    bind:value={outlineitemStyleBorderColor}
    label="Outline border colour" />
  <div id="osb-color-picker" />
</div>
<HelperText />
