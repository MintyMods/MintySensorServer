<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let right;
  const dispatch = createEventDispatcher();

  $: if (right) {
    dispatch("right", right);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={right} min={0} max={500} />
    <span
      slot="label"
      title="current value: {right}"
      style="padding-right: 12px; width: max-content; display: block;">
      Right margin
    </span>
  </FormField>
</div>
