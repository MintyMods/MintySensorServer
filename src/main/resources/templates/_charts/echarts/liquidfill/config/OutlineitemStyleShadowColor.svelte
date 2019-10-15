<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let outlineitemStyleShadowColor;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("oss-color-picker"),
      theme: "nano",
      default: outlineitemStyleShadowColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      outlineitemStyleShadowColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (outlineitemStyleShadowColor && pickr) {
    pickr.setColor(outlineitemStyleShadowColor);
    dispatch("outlineitemStyleShadowColor", outlineitemStyleShadowColor);
  }
</script>

<style>
  .oss-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="oss-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={outlineitemStyleShadowColor}
    label="Outline shadow colour" />
  <div id="oss-color-picker" />
</div>
<HelperText />
