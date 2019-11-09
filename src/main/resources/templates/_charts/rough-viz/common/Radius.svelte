<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let radius;
  const dispatch = createEventDispatcher();

  $: if (radius) {
    dispatch("radius", radius);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={radius} min={0} max={100} />
    <span
      slot="label"
      title="current value: {radius}"
      style="padding-right: 12px; width: max-content; display: block;">
      Circle radius
    </span>
  </FormField>
</div>
