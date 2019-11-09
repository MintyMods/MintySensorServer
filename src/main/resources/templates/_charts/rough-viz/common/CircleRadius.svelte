<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let circleRadius;
  const dispatch = createEventDispatcher();

  $: if (circleRadius) {
    dispatch("circleRadius", circleRadius);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={circleRadius} min={0} max={100} />
    <span
      slot="label"
      title="current value: {circleRadius}"
      style="padding-right: 12px; width: max-content; display: block;">
      Circle radius
    </span>
  </FormField>
</div>
