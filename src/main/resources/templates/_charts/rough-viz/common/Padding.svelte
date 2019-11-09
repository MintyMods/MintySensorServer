
<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";

  export let padding;
  const dispatch = createEventDispatcher();

  $: if (padding) {
    dispatch("padding", padding);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={padding} min={0} max={1} />
    <span
      slot="label"
      title="current value: {padding}"
      style="padding-right: 12px; width: max-content; display: block;">
      Padding between bars
    </span>
  </FormField>
</div>
