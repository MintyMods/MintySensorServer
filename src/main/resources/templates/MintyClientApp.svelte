<div id="minty-sensor-server" />

<Hamburger />

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
        storeIsNavigationOpen,
        storeReadings,
        storeSensors,
        storeTypes
    } from './_stores/stores.js';
    import {
        onMount
    } from 'svelte';
    import {
        onDestroy
    } from 'svelte';
    import Router, {
        link,
        location
    } from 'svelte-spa-router';

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

    let sideNavOpen;
    let sideNav;
    let active = 'index';
    let mainContent;
    let stompClient = null;
    let readings = [];
    let sensors = [];
    let types = [];

    onMount(() => {
        subscribeToStores();
        subscribeToServerEvents();
    });

    onDestroy(() => {
        unsubscribeNavigation();
        unsubscribeReadings();
        unsubscribeSensors();
        unsubscribeTypes();
    });

    function subscribeToStores() {
        const unsubscribeNavigation = storeIsNavigationOpen.subscribe(value => {
            sideNavOpen = value;
        });
        const unsubscribeReadings = storeReadings.subscribe(value => {
            readings = value;
        });
        const unsubscribeSensors = storeSensors.subscribe(value => {
            sensors = value;
        });
        const unsubscribeTypes = storeTypes.subscribe(value => {
            types = value;
        });
    }

    function subscribeToServerEvents() {
        const socket = new SockJS('https://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.debug = () => {};
        stompClient.connect({}, onConnected, onError);
    }

    function setActive(value) {
        active = value;
        storeIsNavigationOpen.set(!sideNavOpen);
    }

    function onConnected() {
        stompClient.subscribe("/events/event", onEventReceived);
        stompClient.send("/app/api.events", {}, {});
    }

    function onEventReceived(payload) {
        let message = JSON.parse(payload.body);
        let content = JSON.parse(message.json);
        storeReadings.set(content.readings);
        storeSensors.set(content.sensors);
        storeTypes.set(content.types);
    }

    function onError(error) {

        if (typeof window.stackBarBottom === 'undefined') {
            window.stackBarBottom = {
                'dir1': 'up',
                'firstpos1': 0,
                'spacing1': 0
            };
        }

        if (window.permanotice) {
            window.permanotice.open();
        } else {
            window.permanotice = PNotify.error({
                title: 'Network Error',
                text: "Failed to communicate with server",
                hide: false,
                icon: 'fad fa-wifi-slash fa-2x',
                textTrusted: true,
                addClass: 'stack-bar-bottom',
                cornerClass: 'ui-pnotify-sharp',
                shadow: false,
                width: '100%',
                stack: window.stackBarBottom,
                modules: {
                    Buttons: {
                        closer: false,
                        sticker: false,
                        classes: {
                            closer: 'fas fa-bomb',
                            pinUp: 'fas fa-anchor',
                            pinDown: 'fas fa-hourglass'
                        }
                    },
                    Mobile: {
                        swipeDismiss: false
                    }
                }
            });
        }
    }

</script>
