<script>
  import { radius } from "./echarts-liquid-fill-store.js";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import { onMount, tick } from "svelte";

  let radiusText = "";

  onMount(async () => {
    await tick();
    radiusText = $radius;
  });

  function update() {
    $radius = radiusText;
  }
</script>

<Textfield on:change={update} bind:value={radiusText} label="Radius of the chart" />
<HelperText>Value in pixels 'px' or as a percentage '%'</HelperText>