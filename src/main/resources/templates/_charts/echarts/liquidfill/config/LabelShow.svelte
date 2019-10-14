<script>
  import { labelShow } from "./echarts-liquid-fill-store.js";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  let labelShowChecked = true;
  $: $labelShow = labelShowChecked;
</script>

<FormField>
  <Switch bind:checked={labelShowChecked} />
  <span slot="label">Show label</span>
</FormField>
