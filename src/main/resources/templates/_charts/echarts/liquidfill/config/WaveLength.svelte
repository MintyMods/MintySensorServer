<script>
  import { waveLength } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    waveLengthText = $waveLength;
  });

  let waveLengthText = "";
  $: if (waveLengthText) {
    $waveLength = waveLengthText;
  }
</script>

<Textfield bind:value={waveLengthText} label="Wave length" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>
