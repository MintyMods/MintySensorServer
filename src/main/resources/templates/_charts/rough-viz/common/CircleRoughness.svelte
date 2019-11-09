<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let circleRoughness;
  const dispatch = createEventDispatcher();

  $: if (circleRoughness) {
    dispatch("circleRoughness", circleRoughness);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={circleRoughness} min={0} max={20} />
    <span
      slot="label"
      title="current value: {circleRoughness}"
      style="padding-right: 12px; width: max-content; display: block;">
      Roughness of circles
    </span>
  </FormField>
</div>
