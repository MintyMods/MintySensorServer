import {
    writable
} from 'svelte/store';
import {
    readable
} from 'svelte/store';

export let storeReadings = writable(readable([]));
export let storeSensors = writable(readable([]));
export let storeTypes = writable(readable([]));



export const storeIsNavigationOpen = writable(false);
export const storeSelectedThemeColor = writable('#ff0000');
export const storeLastNetworkPing = writable(new Date());
export const storeLastNetworkPong = readable(new Date());
export const time = readable(new Date(), function start(set) {
    const interval = setInterval(() => {
        set(new Date());
    }, 1000);

    return function stop() {
        clearInterval(interval);
    };
});
