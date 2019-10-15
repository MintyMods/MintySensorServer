<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  const dispatch = createEventDispatcher();
  export let direction;

  let directionChecked = true;
  $: if (direction || !direction) {
    dispatch("direction", directionChecked ? "right" : "left");
  }
</script>

<FormField>
  <Switch bind:checked={directionChecked} />
  <span slot="label">
    Wave direction
    <span class="config-current-value">{direction}</span>
  </span>
</FormField>
