<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let labelFontSize;

  $: if (labelFontSize) {
    dispatch("labelFontSize", labelFontSize);
  }
</script>

<Textfield type="number" bind:value={labelFontSize} label="Label font size" />
<HelperText />
