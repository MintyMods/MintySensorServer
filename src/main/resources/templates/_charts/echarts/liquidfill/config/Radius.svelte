<script>
  import { radius } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  onMount(async () => {
    await tick();
    radiusText = $radius;
  });

  let radiusText = "";
  $: if (radiusText) {
    $radius = radiusText;
  }
</script>

<Textfield bind:value={radiusText} label="Radius of the chart" />
<HelperText>value in pixels 'px' or as a percentage '%'</HelperText>
