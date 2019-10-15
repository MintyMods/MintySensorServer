<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let period;

  $: if (period) {
    dispatch("period", period);
  }
</script>

<Textfield bind:value={period} label="Wave forward animation period" />
<HelperText>Milliseconds to move forward a wave-length (or auto)</HelperText>
