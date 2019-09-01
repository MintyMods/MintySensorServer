<svelte:head>
    <title>Testing</title>
</svelte:head>
   <script>
    import * as sapper from '@sapper/app';
    import Button from '../_components/Button.svelte';

    let searchTerm = '';

    function handleSubmit() {
        sapper.goto(`/list?query=${searchTerm}`);
    }

</script>

<form on:submit|preventDefault={handleSubmit}>
    <input type="text" bind:value={searchTerm} />
    <Button disabled={!searchTerm} type="submit">
        Submit
    </Button>
</form>
