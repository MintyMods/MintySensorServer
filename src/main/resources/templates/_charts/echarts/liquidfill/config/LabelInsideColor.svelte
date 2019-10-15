<script>
  
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

    const dispatch = createEventDispatcher();
  export let labelInsideColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("li-color-picker"),
      theme: "nano",
      default: labelInsideColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      labelInsideColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }


  $: if (labelInsideColor && pickr) {
    pickr.setColor(labelInsideColor);
    dispatch('labelInsideColor', labelInsideColor);
  }
</script>

<style>
  .li-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="li-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={labelInsideColor}
    label="Color of text while displayed over a wave" />
  <div id="li-color-picker" />
</div>
<HelperText />
