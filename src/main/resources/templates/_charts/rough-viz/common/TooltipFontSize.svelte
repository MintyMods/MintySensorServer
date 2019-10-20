<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let tooltipFontSize;
  const dispatch = createEventDispatcher();

  $: if (tooltipFontSize) {
    dispatch("tooltipFontSize", tooltipFontSize);
  }
</script>

<Textfield bind:value={tooltipFontSize} label="Tooltip font size" />

