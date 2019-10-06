import { writable, readable } from 'svelte/store';

export let storeReadings = writable([]);
export let storeSensors = writable([]);
export let storeTypes = writable([]);
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
