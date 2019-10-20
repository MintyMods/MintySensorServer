<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  export let interactive;
  const dispatch = createEventDispatcher();

  $: if (interactive || !interactive) {
    dispatch("interactive", interactive);
  }
</script>

<FormField>
  <Switch bind:checked={interactive} />
  <span slot="label">Interactive chart</span>
</FormField>
