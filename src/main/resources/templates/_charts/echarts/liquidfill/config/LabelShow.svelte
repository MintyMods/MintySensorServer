<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  const dispatch = createEventDispatcher();
  export let labelShow;
  $: if (labelShow || !labelShow) {
    dispatch("labelShow", labelShow);
  }
</script>

<FormField>
  <Switch bind:checked={labelShow} />
  <span slot="label">Show label</span>
</FormField>
