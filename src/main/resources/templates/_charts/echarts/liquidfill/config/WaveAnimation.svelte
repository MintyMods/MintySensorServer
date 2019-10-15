<script>
  import { createEventDispatcher } from "svelte";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";

  const dispatch = createEventDispatcher();
  export let waveAnimation;
  $: if (waveAnimation || !waveAnimation) {
    dispatch("waveAnimation", waveAnimation);
  }
</script>

<FormField>
  <Switch bind:checked={waveAnimation} />
  <span slot="label">Show wave animation</span>
</FormField>
