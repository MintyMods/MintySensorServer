<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  export let width;
  const dispatch = createEventDispatcher();

  $: if (width) {
    dispatch("width", width);
  }
</script>

<Textfield type="number" bind:value={width} label="Width" />
<HelperText>Note: changes are not applied to the preview</HelperText>
