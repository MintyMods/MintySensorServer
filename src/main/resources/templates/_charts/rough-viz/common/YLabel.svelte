<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let yLabel;
  const dispatch = createEventDispatcher();

  $: if (yLabel) {
    dispatch("yLabel", yLabel);
  }
</script>

<Textfield bind:value={yLabel} label="Y-axis label" />

