<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  export let legend;
  const dispatch = createEventDispatcher();

  $: if (legend || !legend) {
    dispatch("legend", legend);
  }
</script>

<FormField>
  <Switch bind:checked={legend} />
  <span slot="label">Show legend</span>
</FormField>
