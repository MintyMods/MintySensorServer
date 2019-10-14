<script>
  import Select, { Option } from "@smui/select";
  import { shape } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import HelperText from "@smui/textfield/helper-text/index";

  const SHAPES = [
    { type: "container", desc: "Fill Outter Container", icon: "fal fa-border-outer fa-fw" },
    { type: "circle", desc: "Circle", icon: "fal fa-circle fa-fw" },
    {
      type: "rect",
      desc: "Rectangle",
      icon: "fal fa-rectangle-landscape fa-fw"
    },
    {
      type: "roundRect",
      desc: "Rounded Rectangle",
      icon: "fad fa-rectangle-landscape fa-fw"
    },
    { type: "triangle", desc: "Triangle", icon: "fal fa-triangle fa-fw" },
    { type: "diamond", desc: "Diamond", icon: "fal fa-diamond fa-fw" },
    { type: "pin", desc: "Pin", icon: "fal fa-map-marker fa-fw" },
    { type: "arrow", desc: "Arrow", icon: "fal fa-arrow-alt-up fa-fw" }
  ];

  let shapeSelected;

  onMount(async () => {
    await tick();  
    shapeSelected = $shape;
  });

  $: if (shapeSelected) {
    $shape = shapeSelected;
  }

</script>

<Select
  enhanced
  bind:value={shapeSelected}
  label="Gauge shape "
  class="shape"
  menu$class="shape">
  <Option value="" />
  {#each SHAPES as shape}
    <Option value={shape.type} selected={shapeSelected === shape.type}>
      <i class={shape.icon} />
      {shape.desc}
    </Option>
  {/each}
</Select>
  <HelperText></HelperText>