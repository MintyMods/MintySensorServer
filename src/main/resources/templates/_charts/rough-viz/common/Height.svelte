<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import HelperText from "@smui/textfield/helper-text/index";

  export let height;
  const dispatch = createEventDispatcher();

  $: if (height) {
    dispatch("height", height);
  }
</script>

<Textfield type="number" bind:value={height} label="Height" />
<HelperText>Note: changes are not applied to the preview</HelperText>
