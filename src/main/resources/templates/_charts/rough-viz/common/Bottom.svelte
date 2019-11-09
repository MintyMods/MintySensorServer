<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let bottom;
  const dispatch = createEventDispatcher();

  $: if (bottom) {
    dispatch("bottom", bottom);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={bottom} min={0} max={500} />
    <span
      slot="label"
      title="current value: {bottom}"
      style="padding-right: 12px; width: max-content; display: block;">
      Bottom margin
    </span>
  </FormField>
</div>
