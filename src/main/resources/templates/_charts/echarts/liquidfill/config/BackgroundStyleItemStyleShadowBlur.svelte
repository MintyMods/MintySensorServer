<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleItemStyleShadowBlur;

  onMount(async () => {
    await tick();
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  $: if (backgroundStyleItemStyleShadowBlur) {
    dispatch(
      "backgroundStyleItemStyleShadowBlur",
      backgroundStyleItemStyleShadowBlur
    );
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={backgroundStyleItemStyleShadowBlur}
      min={-1}
      max={250}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {backgroundStyleItemStyleShadowBlur}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background shadow blur size
    </span>
  </FormField>
</div>
