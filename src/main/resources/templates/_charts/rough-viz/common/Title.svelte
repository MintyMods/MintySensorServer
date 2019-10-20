<script>
  import { createEventDispatcher } from "svelte";
  import Textfield, { Input, Textarea } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";

  export let title;
  const dispatch = createEventDispatcher();

  $: if (title) {
    dispatch("title", title);
  }
</script>

<Textfield bind:value={title} label="Chart title" />

