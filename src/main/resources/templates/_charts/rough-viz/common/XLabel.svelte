<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let xLabel;
  const dispatch = createEventDispatcher();

  $: if (xLabel) {
    dispatch("xLabel", xLabel);
  }
</script>

<Textfield bind:value={xLabel} label="X-axis label" />

