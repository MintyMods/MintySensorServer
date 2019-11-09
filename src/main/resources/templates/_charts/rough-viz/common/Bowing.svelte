<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let bowing;
  const dispatch = createEventDispatcher();

  $: if (bowing) {
    dispatch("bowing", bowing);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={bowing} min={0} max={20} />
    <span
      slot="label"
      title="current value: {bowing}"
      style="padding-right: 12px; width: max-content; display: block;">
      Chart bowing
    </span>
  </FormField>
</div>
