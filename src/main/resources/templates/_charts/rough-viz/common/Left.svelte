<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let left;
  const dispatch = createEventDispatcher();

  $: if (left) {
    dispatch("left", left);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={left} min={0} max={500} />
    <span
      slot="label"
      title="current value: {left}"
      style="padding-right: 12px; width: max-content; display: block;">
      Left margin
    </span>
  </FormField>
</div>
