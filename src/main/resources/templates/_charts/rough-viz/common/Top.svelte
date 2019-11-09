<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let top;
  const dispatch = createEventDispatcher();

  $: if (top) {
    dispatch("top", top);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={top} min={0} max={500} />
    <span
      slot="label"
      title="current value: {top}"
      style="padding-right: 12px; width: max-content; display: block;">
      Top margin
    </span>
  </FormField>
</div>
