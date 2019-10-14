<script>
  import { amplitude } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    amplitudeText = $amplitude;
  });

  let amplitudeText = "";
  $: if (amplitudeText) {
    $amplitude = amplitudeText;
  }
</script>

<Textfield bind:value={amplitudeText} label="Amplitude of the wave" />
<HelperText>
  value in pixels 'px' or as a percentage '%' (relative to diameter)
</HelperText>
