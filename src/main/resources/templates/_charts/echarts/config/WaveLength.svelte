<script>
  import { waveLength } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let waveLengthText = "";

  onMount(async () => {
    await tick();
    waveLengthText = $waveLength;
  });

  function update() {
    $waveLength = waveLengthText;
  }
</script>

<Textfield on:change={update} bind:value={waveLengthText} label="Wave length" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>