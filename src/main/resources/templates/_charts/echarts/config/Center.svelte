<script>
  import { center } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let centerX = "";
  let centerY = "";

  onMount(async () => {
    await tick();
    centerX = $center[0];
    centerY = $center[1];
  });

  function update() {
    $center[0] = centerX;
    $center[1] = centerY;
  }
</script>

<Textfield
  class="center"
  on:change={update}
  bind:value={centerX}
  label="X Position of Chart" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>
<Textfield
  class="center"
  on:change={update}
  bind:value={centerY}
  label="Y Position of Chart" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>
