<script>
  import { period } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let periodText = "";

  onMount(async () => {
    await tick();
    periodText = $period;
  });

  function update() {
    $period = periodText;
  }
</script>

<Textfield on:change={update} bind:value={periodText} label="Wave Forward Animation Period" />
<HelperText>Milliseconds to move forward a wave-length or auto</HelperText>