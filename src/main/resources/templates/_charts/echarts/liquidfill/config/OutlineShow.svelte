<script>
  import { outlineShow } from "./echarts-liquid-fill-store.js";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";
  
  let outlineShowChecked = true;
  $: $outlineShow = outlineShowChecked;
</script>

<FormField>
  <Switch bind:checked={outlineShowChecked} />
  <span slot="label">Show outline</span>
</FormField>
