<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let stroke;
  const dispatch = createEventDispatcher();

  onMount(async () => {
    await tick();
    initPickr();
  });

  let pickr;
  function initPickr() {
    pickr = Pickr.create({
      el: document.getElementById("color-picker"),
      theme: "nano",
      default: stroke,
      components: {
        preview: true,
        opacity: true,
        hue: true
      }
    });
    pickr.on("changestop", instance => {
      stroke = instance
        .getColor()
        .toRGBA()
        .toString(2);
    });
  }

  $: if (stroke && pickr) {
    pickr.setColor(stroke);
    dispatch("stroke", stroke);
  }
</script>

<style>
  .color-picker-wrapper {
    display: flex;
    flex-flow: column;
    position: relative;
  }
</style>

<div class="color-picker-wrapper">
  <Textfield withLeadingIcon bind:value={stroke} label="Stroke colour" />
  <div id="color-picker" />
</div>
