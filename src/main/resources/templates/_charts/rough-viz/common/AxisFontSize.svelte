<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let axisFontSize;
  const dispatch = createEventDispatcher();

  $: if (axisFontSize) {
    dispatch("axisFontSize", axisFontSize);
  }
</script>

<Textfield bind:value={axisFontSize} label="Axis font size" />
<HelperText />
