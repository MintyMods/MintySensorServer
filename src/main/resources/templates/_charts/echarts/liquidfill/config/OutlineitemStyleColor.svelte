<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let outlineitemStyleColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("os-color-picker"),
      theme: "nano",
      default: outlineitemStyleColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (outlineitemStyleColor && pickr) {
    pickr.setColor(outlineitemStyleColor);
    dispatch("outlineitemStyleColor", outlineitemStyleColor);
  }
</script>

<style>
  .os-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="os-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleColor}
    label="Outline colour" />
  <div id="os-color-picker" />
</div>
<HelperText />
