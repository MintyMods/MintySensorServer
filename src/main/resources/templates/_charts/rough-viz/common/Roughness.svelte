<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let roughness;
  const dispatch = createEventDispatcher();

  $: if (roughness) {
    dispatch("roughness", roughness);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={roughness} min={0} max={20} />
    <span
      slot="label"
      title="current value: {roughness}"
      style="padding-right: 12px; width: max-content; display: block;">
      Roughness level of chart
    </span>
  </FormField>
</div>
