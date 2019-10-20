<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  export let circle;
  const dispatch = createEventDispatcher();

  $: if (circle || !circle) {
    dispatch("circle", circle);
  }
</script>

<FormField>
  <Switch bind:checked={circle} />
  <span slot="label">Add circles</span>
</FormField>
