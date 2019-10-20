<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  export let curbZero;
  const dispatch = createEventDispatcher();

  $: if (curbZero || !curbZero) {
    dispatch("curbZero", curbZero);
  }
</script>

<FormField>
  <Switch bind:checked={curbZero} />
  <span slot="label">Force (X, Y) axes to (0, 0)</span>
</FormField>
