<script>
    import {
        fly
    } from 'svelte/transition';
    import {
        quintIn
    } from 'svelte/easing';
    import {
        navigationIsOpen
    } from '../_stores/main-state.js';
    import FavIcon from '../_components/FavIcon.svelte';
    import Navigation from '../_components/Navigation.svelte';
    import Hamburger from '../_components/Hamburger.svelte';
    export let segment;
    let condition;
    const unsubscribe = navigationIsOpen.subscribe(value => {
        condition = value;
    });

</script>

<style>
    /* remove overlay when side nav is open
    :global(.sidenav-overlay) {
        height: 0px;
        width: 0px;
    }*/

    .container,
    .pusher,
    .content {
        height: 100%;
        padding: 10px;
    }

    .container {
        height: 100vh;
        width: 100%;
        perspective: 1500px;
        -webkit-perspective: 1500px;
        perspective-origin: 0% 50%;
        margin: 0px !important;
        max-width: none !important;
    }

    .open {
        border: 2px solid rgba(0, 0, 0, 0.5) !important;
        border-radius: 10px;
        transform: translate3d(90px, 9px, -156px) rotateY(-51deg) scale3d(0.8, 0.8, 0.9);
        transition: all 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        -webkit-transition: -webkit-transform all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        overflow: hidden;
        -moz-box-shadow: 25px 25px 35px rgba(200, 200, 200, 0.5);
        -webkit-box-shadow: 25px 25px 35px rgba(200, 200, 200, 0.5);
        box-shadow: 25px 25px 35px rgba(200, 200, 200, 0.5);
    }

    .close {
        border: 0px solid rgba(0, 0, 0, 0) !important;
        transform: translate3d(0, 0, 0) rotateY(0) scale3d(1, 1, 1);
        transition: all 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        -webkit-transition: -webkit-transform all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        border: 0px solid tra !important;
        box-shadow: none;
    }

</style>

<FavIcon />

<Hamburger />

<Navigation {segment} />

<div class="container">
    <div class="pusher" class:open={condition} class:close={!condition}>
        <main class="content">
            <slot></slot>
        </main>
    </div>
</div>
