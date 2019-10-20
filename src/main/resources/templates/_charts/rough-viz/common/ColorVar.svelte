<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let colorVar;
  const dispatch = createEventDispatcher();

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("bar-color-picker"),
      theme: "nano",
      default: colorVar,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      colorVar = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (colorVar && pickr) {
    pickr.setColor(colorVar);
    dispatch("colorVar", colorVar);
  }
</script>

<style>
  .bar-color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="bar-color-picker-wrapper">
  <Textfield withLeadingIcon bind:value={colorVar} label="Point colour" />
  <div id="bar-color-picker" />
</div>
