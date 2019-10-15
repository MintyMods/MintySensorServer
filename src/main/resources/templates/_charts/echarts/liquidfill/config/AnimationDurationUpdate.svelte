<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let animationDurationUpdate;

  $: if (animationDurationUpdate) {
    dispatch("animationDurationUpdate", animationDurationUpdate);
  }
</script>

<Textfield
  bind:value={animationDurationUpdate}
  label="Update animation duration" />
<HelperText>value in milliseconds</HelperText>
