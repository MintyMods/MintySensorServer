<script>
  import Slider from "@smui/slider";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  let dialog;
  let value = 100;

  function openNative() {
    let native = document.getElementById("native");
    native.showModal();
  }
</script>

<style>
  .wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    /* height: 80vh; */
  }
  .slider {
    width: 300px;
  }
  :global(.app-content){
    /* height:100vh; */
  }
</style>

<Dialog bind:this={dialog}>
<div id="content">
  <Content>
    <p>Current Value : {value}</p>
    <Slider

      min={-500}
      max={2500}
      step={100}
      discrete
      displayMarkers />
  </Content>
  </div>
</Dialog>

<div class="wrapper">
  <Button
    action="cancel"
    use={[InitialFocus]}
    on:click={() => dialog.open()}
    variant="raised">
    <Label>Show dialog</Label>
  </Button>
  <!-- <Button
    action="cancel"
    use={[InitialFocus]}
    on:click={() => openNative()}
    variant="raised">
    <Label>Show native dialog</Label>
  </Button> -->
  <div class="slider">
  <Slider    
    bind:value
    min={-500}
    max={2500}
    step={100}
    discrete
    displayMarkers />
    </div> 
</div>

<dialog id="native">
  <h2>Native dialog content</h2>
    <p>Current Value : {value}</p>
    <Slider

      min={-500}
      max={2500}
      step={100}
      discrete
      displayMarkers />
  </dialog>