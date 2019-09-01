<script>
      import '../_scss/Elevation.scss';
    import {
        onMount
    } from 'svelte';
    //import Navigation from '../_components/Navigation.svelte';    
    const timeout = 10000;
    let snoozing = false;
    let sleeping = false;
    let snoozeInterval;
    let sleepInterval;
    let hamburger;
    let pulse;

    onMount(() => {
        // var hamburger = document.getElementById('hamburger');
        // var options = {
        // direction: 'top',
        // hoverEnabled: true,
        // toolbarEnabled: false
        // };
        // hamburger = M.FloatingActionButton.init(hamburger, options)[0];
        // snoozeInterval = setTimeout(() => {
        // Snoozing();
        // }, timeout);
    });

    function Snoozing() {
        snoozing = true;
        sleepInterval = setTimeout(() => {
            Sleeping();
        }, timeout);
    }

    function Sleeping() {
        sleeping = true;
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


    import Fab, {
        Label,
        Icon
    } from '@smui/fab';

    function doSomething() {
        alert('something');
    }

</script>

<style>
    .fa-bars {
        font-size: 2em;
    }

    .fixed-action-btn {
        -webkit-transition: all 1s ease !important;
        -moz-transition: all 1s ease !important;
        -o-transition: all 1s ease !important;
        transition: all 1s ease !important;
        filter: alpha(opacity=1);
        opacity: 1;
        position: fixed !important;
        left: 10px !important;
        top: 0px !important;
        right: auto;
    }

    .snoozing {
        -webkit-transition: all 1s ease !important;
        -moz-transition: all 1s ease !important;
        -o-transition: all 1s ease !important;
        transition: all 1s ease !important;
        filter: alpha(opacity=0.5);
        opacity: 0.5;
    }

    .sleeping {
        -webkit-transition: all 1s ease !important;
        -moz-transition: all 1s ease !important;
        -o-transition: all 1s ease !important;
        transition: all 1s ease !important;
        filter: alpha(opacity=0);
        opacity: 0;
    }

</style>

<svelte:body on:mousemove={ResetTimeout} />

<Fab id="hamburger">
    <div class='fixed-action-btn' class:sleeping class:snoozing>
        <a class:z-depth-4="{!snoozing}" class:pulse on:mouseover="{()=>pulse=true}" on:mouseout="{()=>pulse=false}" href="#!" data-target="slide-out" class="sidenav-trigger btn-large btn-floating waves-effect">
            <i class="fad fa-bars"></i>
        </a>
    </div>
</Fab>





<Fab on:click={doSomething}>
    <Icon class="material-icons">favorite</Icon>
</Fab>
