<script>
    import './_minty-client-app.scss';
    import Hamburger from './_components/Hamburger.svelte';
    import Navigation from './_components/Navigation.svelte';
    import Drawer, {
        AppContent,
        Content,
        Header,
        Title,
        Subtitle,
        Scrim
    } from '@smui/drawer';
    import {
        storeIsNavigationOpen
    } from './_components/_stores.js';
    import {
        onMount
    } from 'svelte';

    import Views from './_routes/Views.svelte';
    import Testing from './_routes/Testing.svelte';
    import Test from './_routes/Test.svelte';
    import Settings from './_routes/Settings.svelte';
    import Sensors from './_routes/Sensors.svelte';
    import Readings from './_routes/Readings.svelte';
    import Providers from './_routes/Providers.svelte';
    import Notifications from './_routes/Notifications.svelte';
    import Home from './_routes/Index.svelte';
    import Hosts from './_routes/Hosts.svelte';
    import Devices from './_routes/Devices.svelte';
    import About from './_routes/About.svelte';
    import Chat from './_routes/Client.svelte';
    import NotFound from './_routes/_error.svelte';

    let sideNavOpen;
    let sideNav;
    let active = 'index';
    let mainContent;

    onMount(() => {
        const unsubscribe = storeIsNavigationOpen.subscribe(value => {
            sideNavOpen = value;
        });
    });

    function setActive(value) {
        active = value;
        storeIsNavigationOpen.set(!sideNavOpen);
    }

    import Router, {
        link,
        location
    } from 'svelte-spa-router';


    const routes = {
        '/test': Test,
        '/testing': Testing,
        '/settings': Settings,
        '/sensors': Sensors,
        '/readings': Readings,
        '/providers': Providers,
        '/notifications': Notifications,
        '/views': Views,
        '/hosts': Hosts,
        '/devices': Devices,
        '/about': About,
        '/index': Home,
        '/chat': Chat,
        '/': Home,
        '*': NotFound,
    };

</script>
<style>


</style>
<Hamburger />
<!--variant="modal"-->
<aside>
    <div class="drawer-container">
        <Drawer variant="dismissible" bind:this={sideNav} bind:open={sideNavOpen}>
            <Navigation />
        </Drawer>
        <Scrim />
        <AppContent class="app-content">
            <main class="main-content" bind:this={mainContent} class:open={sideNavOpen} class:close={!sideNavOpen}>
                <Router {routes} />
            </main>
        </AppContent>
    </div>
</aside>
