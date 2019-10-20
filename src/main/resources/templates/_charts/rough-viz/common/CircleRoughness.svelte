<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  

  export let circleRoughness;
  const dispatch = createEventDispatcher();

  onMount(async () => {
    await tick();
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

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
