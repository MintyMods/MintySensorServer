<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let amplitude;

$: if (amplitude) {
    dispatch('amplitude',amplitude);
  }
</script>

<Textfield bind:value={amplitude} label="Amplitude of the wave" />
<HelperText>
  value in pixels 'px' or as a percentage '%' (relative to diameter)
</HelperText>
