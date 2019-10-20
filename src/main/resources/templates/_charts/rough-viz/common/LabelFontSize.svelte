<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let labelFontSize;
  const dispatch = createEventDispatcher();

  $: if (labelFontSize) {
    dispatch("labelFontSize", labelFontSize);
  }
</script>

<Textfield bind:value={labelFontSize} label="Label font size" />

