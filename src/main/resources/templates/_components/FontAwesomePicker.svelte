<script>
    import './_fontawesomepicker.scss';

    import Textfield, {
        Input,
        Textarea
    } from '@smui/textfield';
    import Icon from '@smui/textfield/icon';
    import HelperText from '@smui/textfield/helper-text';
    import CharacterCounter from '@smui/textfield/character-counter';
    import {
        Icon as CommonIcon
    } from '@smui/common';
    import FloatingLabel from '@smui/floating-label';
    import LineRipple from '@smui/line-ripple';
    import NotchedOutline from '@smui/notched-outline';

    import {
        onMount
    } from 'svelte';

    export let query = '';
    export let selected;

    let fab;
    let count = 0;
    let icons = [];
    let result = [];
    let type = "fal";

    onMount(() => {
        let styles = window.___FONT_AWESOME___.styles;
        fab = Object.keys(styles.fab)
        icons = fab.concat(Object.keys(styles.fa)).sort();
        icons = Object.keys(styles.fa);

    });

    function filterList(query) {
        if (query == '') return [];
        for (let icon of icons) {
            if (count > 19) break;
            if (icon.toLowerCase().indexOf(query.toLowerCase()) != -1) {
                count++;
                result = [...result, icon];
            }
        }
        return result;
    }

    function isBrand(icon) {
        if (!fab) return false;
        let brand = fab.includes(icon);
        return brand;
    }

    $: result = filterList(query);

</script>

<br /><br />
<div class="filtering-list">
    <div class="filter-search">
        <input bind:value={query} type="text" class="search">
        <Textfield variant="outlined" withLeadingIcon bind:value={query} label="Find Icon" input$aria-controls="helper-text-outlined-b" input$aria-describedby="helper-text-outlined-b">
            <Icon class="far fa-times-square">event</Icon>
        </Textfield>
        <HelperText id="helper-text-outlined-b">Search for an icon by name</HelperText>
    </div>
    <ul class="column">
        {#each result as name}
           {@debug name}
            <li><span><i class="{isBrand(name) ? 'fab' : type} fa-{name} fa-2x"></i> {name}</span></li>
        {:else}
            <li><span><i class="far fa-times-square"></i> There is no item matching '{query}' that can be displayed.</span></li>        
        {/each}
    </ul>
</div>
