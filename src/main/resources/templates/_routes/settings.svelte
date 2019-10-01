<script>
  import Slider from "@smui/slider";
  import Button from "@smui/button";
  import Tab, { Icon, Label } from "@smui/tab";
  import Dialog, { Title, Content, Actions, InitialFocus } from "@smui/dialog";
  let dialog;
  let value = 100;
</script>

<style>
  .wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 80vh;
  }
  .slider {
    width: 300px;
  }
</style>

<Dialog bind:this={dialog}>
  <Content>
    <p>Current Value : {value}</p>
    <Slider
      bind:value
      min={-500}
      max={2500}
      step={100}
      discrete
      displayMarkers />
  </Content>
</Dialog>

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
</div>
