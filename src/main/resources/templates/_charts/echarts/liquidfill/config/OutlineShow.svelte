<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  const dispatch = createEventDispatcher();
  export let outlineShow;

  $: if (outlineShow || !outlineShow) {
    dispatch("outlineShow", outlineShow);
  }
</script>

<FormField>
  <Switch bind:checked={outlineShow} />
  <span slot="label">Show outline</span>
</FormField>
