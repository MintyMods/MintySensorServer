import App from './MintyClientApp.svelte';

const app = new App({
    target: document.body,
    props: {
        name: 'mss'
    }
});

window.app = app;

export default app;
