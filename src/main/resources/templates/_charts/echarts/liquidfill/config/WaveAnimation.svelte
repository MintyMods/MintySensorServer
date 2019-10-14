<script>
  import { waveAnimation } from "./echarts-liquid-fill-store.js";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  let waveAnimationChecked = true;
  $: $waveAnimation = waveAnimationChecked;
</script>

<FormField>
  <Switch bind:checked={waveAnimationChecked} />
  <span slot="label">Show wave animation</span>
</FormField>
