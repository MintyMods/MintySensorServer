<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let waveLength;

  $: if (waveLength) {
    dispatch("waveLength", waveLength);
  }
</script>

<Textfield bind:value={waveLength} label="Wave length" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>
