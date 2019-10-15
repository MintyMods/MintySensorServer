<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let radius;

  $: if (radius) {
    dispatch("radius", radius);
  }
</script>

<Textfield bind:value={radius} label="Radius of the chart" />
<HelperText>value in pixels 'px' or as a percentage '%'</HelperText>
