<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let fillWeight;
  const dispatch = createEventDispatcher();

  $: if (fillWeight) {
    dispatch("fillWeight", fillWeight);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={fillWeight} min={0} max={5} />
    <span
      slot="label"
      title="current value: {fillWeight}"
      style="padding-right: 12px; width: max-content; display: block;">
      Weight of inner paths' color
    </span>
  </FormField>
</div>
