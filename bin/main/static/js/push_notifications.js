
function showMessage(message) {
	
}

  if (!('serviceWorker' in navigator)) {
    // 
	  showMessage("Service Worker isn't supported on this browser, disable or hide UI.");
    return;
  }
 
  if (!('PushManager' in window)) {
    // Push isn't supported on this browser, disable or hide UI.
    return;
  }
 
 
 
function registerServiceWorker() {
  return navigator.serviceWorker.register('service-worker.js')
  .then(function(registration) {
    console.log('Service worker successfully registered.');
    return registration;
  })
  .catch(function(err) {
    console.error('Unable to register service worker.', err);
  });
}
 

 

 

function askPermission() {

  return new Promise(function(resolve, reject) {

    const permissionResult = Notification.requestPermission(function(result) {

      resolve(result);

    });

 

    if (permissionResult) {

      permissionResult.then(resolve, reject);

    }

  })

  .then(function(permissionResult) {

    if (permissionResult !== 'granted') {

      throw new Error('We weren\'t granted permission.');

    }

  });

}

 

 

function getNotificationPermissionState() {
  if (navigator.permissions) {
    return navigator.permissions.query({name: 'notifications'})
    .then((result) => {
      return result.state;
    });
  }
 
  return new Promise((resolve) => {
    resolve(Notification.permission);
  });
}
 

 

function subscribeUserToPush() {
  return getSWRegistration()
  .then(function(registration) {
    const subscribeOptions = {
      userVisibleOnly: true,
      applicationServerKey: urlBase64ToUint8Array(
        'BEl62iUYgUivxIkv69yViEuiBIa-Ib9-SkvMeAtA3LFgDzkrxZJjSgSnfckjBJuBkr3qBUYIHBQFLXYp5Nksh8U'
      )
    };
 
    return registration.pushManager.subscribe(subscribeOptions);
  })
  .then(function(pushSubscription) {
    console.log('Received PushSubscription: ', JSON.stringify(pushSubscription));
    return pushSubscription;
  });
}