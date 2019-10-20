<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let titleFontSize;
  const dispatch = createEventDispatcher();

  $: if (titleFontSize) {
    dispatch("titleFontSize", titleFontSize);
  }
</script>

<Textfield bind:value={titleFontSize} label="Title font size" />
