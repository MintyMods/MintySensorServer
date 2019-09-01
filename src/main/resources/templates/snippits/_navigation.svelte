    let navIsOpen;
    import {
        storeIsNavigationOpen
    } from './_stores.js';    
    const unsubscribe = storeIsNavigationOpen.subscribe(value => {
        navIsOpen = value;
    });

