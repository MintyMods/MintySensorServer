<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let animationDuration;

  $: if (animationDuration) {
    dispatch('animationDuration', animationDuration);
  }
</script>

<Textfield
  bind:value={animationDuration}
  label="Initial animation duration" />
<HelperText>value in milliseconds</HelperText>
