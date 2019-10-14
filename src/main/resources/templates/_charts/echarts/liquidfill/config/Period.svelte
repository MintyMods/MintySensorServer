<script>
  import { period } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    periodText = $period;
  });

  let periodText = "";
  $: if (periodText) {
    $period = periodText;
  }
</script>

<Textfield bind:value={periodText} label="Wave forward animation period" />
<HelperText>Milliseconds to move forward a wave-length (or auto)</HelperText>
