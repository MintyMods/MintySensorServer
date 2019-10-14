<script>
  import { onMount } from "svelte";
  import Slider from "@smui/slider";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import HelperText from "@smui/textfield/helper-text/index";
  import CharacterCounter from "@smui/textfield/character-counter/index";
  import { Icon as CommonIcon } from "@smui/common";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import NotchedOutline from "@smui/notched-outline";
  let dialog;
  let value = 100;

  function openNative() {
    let native = document.getElementById("native");
    native.showModal();
  }

  // import { MDCSlider } from "@material/slider";
  // import { MDCDialog } from "@material/dialog";
  // onMount(() => {
  //   const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
  //   const slider = new MDCSlider(document.querySelector(".mdc-slider"));
  //   dialog.listen("MDCDialog:opened", () => {
  //     slider.layout();
  //   });
  // });
  let valueManualC;
  let valueStandardA;
</script>

<style>
  .wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh !important;
    width: 100%;
  }
  :global(.main-content) {
    height: 100%;
  }
  .slider {
    width: 300px;
  }
</style>

<div class="wrapper">
      <div>
        <Textfield variant="outlined">
          <Input bind:value={valueManualC} id="input-manual-c" aria-controls="helper-text-manual-c" aria-describedby="helper-text-manual-c" />
          <NotchedOutline>
            <FloatingLabel for="input-manual-c">Label</FloatingLabel>
          </NotchedOutline>
        </Textfield>
        <HelperText id="helper-text-manual-c">Helper Text</HelperText>

        <pre class="status">Value: {valueManualC}</pre>
      </div>
<br/>
      <div>
        <Textfield bind:value={valueStandardA} label="Label" input$aria-controls="helper-text-standard-a" input$aria-describedby="helper-text-standard-a" />
        <HelperText id="helper-text-standard-a">Helper Text</HelperText>

        <pre class="status">Value: {valueStandardA}</pre>
      </div>

</div>

<!-- <Dialog class="mdc-dialog" bind:this={dialog}>
  <div id="content">
    <Content>
      <p>Current Value : {value}</p>
      <Slider
        class="mdc-slider"
        min={-500}
        max={2500}
        step={100}
        discrete
        displayMarkers />
    </Content>
  </div>
</Dialog> -->

<!-- 
<div class="wrapper">
  <Button
    action="cancel"
    use={[InitialFocus]}
    on:click={() => dialog.open()}
    variant="raised">
    <Label>Show dialog</Label>
  </Button>

  <div class="slider">
    <Slider
      bind:value
      min={-500}
      max={2500}
      step={100}
      discrete
      displayMarkers />
  </div>
</div> -->
<!-- 
<dialog id="native">
  <h2>Native dialog content</h2>
  <p>Current Value : {value}</p>
  <Slider min={-500} max={2500} step={100} discrete displayMarkers />
</dialog> -->
