<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let innerStrokeWidth;
  const dispatch = createEventDispatcher();

  $: if (innerStrokeWidth) {
    dispatch("innerStrokeWidth", innerStrokeWidth);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={innerStrokeWidth} min={0} max={25} />
    <span
      slot="label"
      title="current value: {innerStrokeWidth}"
      style="padding-right: 12px; width: max-content; display: block;">
      Stroke-width inner
    </span>
  </FormField>
</div>
