<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  const dispatch = createEventDispatcher();
  export let center;
  let centerX = "";
  let centerY = "";

  onMount(async () => {
    await tick();
    centerX = center[0];
    centerY = center[1];
  });


$: if (centerX || centerY) {
   dispatch("center", [centerX, centerY]);
  }
</script>

<Textfield bind:value={centerX} label="X position of chart" />
<HelperText>value in pixels 'px' or as a percentage '%'</HelperText>
<Textfield bind:value={centerY} label="Y position of chart" />
<HelperText>value in pixels 'px' or as a percentage '%'</HelperText>
