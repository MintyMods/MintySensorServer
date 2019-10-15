<script>
    import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

    const dispatch = createEventDispatcher();
  export let backgroundStyleColor;

  onMount(async () => {
    await tick();
      initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bs-color-picker"),
      theme: "nano",
      default: backgroundStyleColor,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      backgroundStyleColor = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (backgroundStyleColor && pickr) {
    pickr.setColor(backgroundStyleColor);
    dispatch('backgroundStyleColor', backgroundStyleColor);
  }
</script>

<style>
  .bs-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bs-color-picker-wrapper">
  <Textfield
    withLeadingIcon
    bind:value={backgroundStyleColor}
    label="Background fill colour" />
  <div id="bs-color-picker" />
</div>
<HelperText />
