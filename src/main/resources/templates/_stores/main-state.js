import {
    writable
} from 'svelte/store';
import {
    readable
} from 'svelte/store';

export let storeReadings = writable(readable([]));
export let storeSensors = writable(readable([]));
export let storeTypes = writable(readable([]));


export let storeIsNavigationOpen = writable(false);
export let storeSelectedThemeColor = writable('#ff0000');
export let storeLastNetworkPing = writable(new Date());
export let storeLastNetworkPong = readable(new Date());

export const time = readable(new Date(), function start(set) {
    const intervalTime = setInterval(() => {
        set(new Date());
    }, 1000);

    return function stop() {
        clearInterval(intervalTime);
    };
});

let count = 0;

export let storeDemoCurrentJsonFile = readable(0, function start(set) {
    const intervalCount = setInterval(() => {
        if (count >= 500) {
            count = 0;
        }
        count++;
        set(count);
    }, 1000);

    return function stop() {
        clearInterval(intervalCount);
    };
});
