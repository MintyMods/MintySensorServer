<script>
  import { direction } from "./echarts-liquid-fill-store.js";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  let directionChecked = true;
  $: $direction = directionChecked ? "right" : "left";
</script>

<FormField>
  <Switch bind:checked={directionChecked} />
  <span slot="label">
    Wave Direction
    <span class="config-current-value">{$direction}</span>
  </span>
</FormField>
