<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let labelColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("labelColor-picker"),
      theme: "nano",
      default: labelColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      labelColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (labelColor && pickr) {
    pickr.setColor(labelColor);
    dispatch("labelColor", labelColor);
  }
</script>

<style>
  .labelColor-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="labelColor-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={labelColor}
    label="Color of text when displayed on background" />
  <div id="labelColor-picker" />
</div>
<HelperText />
