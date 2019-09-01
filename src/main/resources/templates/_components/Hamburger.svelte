<script>
    import './_hamburger.scss';
    import {
        onMount
    } from 'svelte';
    import Fab, {
        Label,
        Icon
    } from '@smui/fab';
    import {
        storeIsNavigationOpen
    } from './_stores.js';
    const timeout = 1000;
    let snoozing = false;
    let sleeping = false;
    let snoozeInterval;
    let sleepInterval;
    let hamburger;
    let sideNavOpen;
    let pulse = false;

    const unsubscribe = storeIsNavigationOpen.subscribe(value => {
        sideNavOpen = value;
    });

    onMount(() => {
        snoozeInterval = setTimeout(() => {
            Snoozing();
        }, timeout);
    });

    function toggleNavigation() {
        storeIsNavigationOpen.set(!sideNavOpen);
    }

    function Snoozing() {
        if (!sideNavOpen) {
            snoozing = true;
            sleepInterval = setTimeout(() => {
                Sleeping();
            }, timeout);
        }
    }

    function Sleeping() {
        if (!sideNavOpen) {
            sleeping = true;
        }
    }

    function ResetTimeout() {
        snoozing = false;
        sleeping = false;
        clearTimeout(snoozeInterval);
        clearTimeout(sleepInterval);
        snoozeInterval = setTimeout(() => {
            Snoozing();
        }, timeout);
    }

</script>

<svelte:body on:mousemove={ResetTimeout} />
<div class="hamburger-container" on:mouseover="{()=>pulse=true}" on:mouseout="{()=>pulse=false}" class:sleeping class:snoozing>
    <div id='hamburger' on:click={()=>toggleNavigation()} class:nav-open={sideNavOpen} class:pulse>
        <Fab color="primary" variant='outlined' class="mdc-button--outlined">
            <i class="fal fa-bars"></i>
        </Fab>
    </div>
</div>
