<script>
  import { amplitude } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let amplitudeText = "";

  onMount(async () => {
    await tick();
    amplitudeText = $amplitude;
  });

  function update() {
    $amplitude = amplitudeText;
  }
</script>

<Textfield on:change={update} bind:value={amplitudeText} label="Amplitude of the wave" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>