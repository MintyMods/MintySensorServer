<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let color;

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("color-picker"),
      theme: "nano",
      default: color,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      color = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (color && pickr) {
    pickr.setColor(color);
    dispatch("color", color);
  }
</script>

<style>
  .color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

{#each color as item, index}
<div class="color-picker-wrapper">
  <Textfield withLeadingIcon bind:value={color} label="Wave colour" />
  <div id="color-picker" />
</div>
<HelperText />
{/each}
