<script>
  export let disabled = false, type;
</script>

<style>
  button {
    /* custom styles */
  }
</style>

<button {disabled} {type} on:click>
  <slot></slot>
</button>