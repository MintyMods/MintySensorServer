PNotify.defaults.delay = 2000;
PNotify.defaults.styling = 'material';
Pace.options.ajax.trackWebSockets = false;


/** Hook into the search box to provide some default behaviour */
$(document).ready(function () {
    $('.top_search .input-group input').on("keyup", function () {
        var g = $(this).val().toLowerCase();
        $(".mss-filter").each(function () {
            var s = $(this).text().toLowerCase();
            $(this).closest('.mss-filter')[s.indexOf(g) !== -1 ? 'show' : 'hide']();
        });
        if ($(".mss-filter:visible").length == 0) {
            //	    	PNotify.closeAll();
            MSS.alert.show({
                title: 'No Results Found',
                text: 'Try some different search criteria'
            });
        }
    });
    $('.top_search .input-group input').on("focus", function () {
        PNotify.closeAll();
    });

});



var mss = new function () {

    var sendNotification = function (msg) { // var PRIVATE

        var core = {
            text: msg.text ? msg.text : 'Pop In Notification Type',
            title: msg.title ? msg.title : 'Notification shown within the Browser',
            type: msg.type ? msg.type : 'error'
        };

        var modules = {
            'modules': {
                'Desktop': {
                    'desktop': msg.desktop
                }
            }
        };
        wrapper = Object.assign({}, core, modules);

        switch (wrapper.type) {
            case 'notice':
                PNotify.notice({
                    title: 'Custom Styling',
                    text: 'I have an additional class that\'s used to give me special styling. I always wanted to be pretty. I also use NonBlock.js.',
                    styling: {},
                    addClass: 'custom nonblock',
                    icon: 'far fa-file-image fa-3x'
                });
                break;
            case 'info':
                PNotify.info(wrapper);
                break;
            case 'success':
                PNotify.success(wrapper);
                break;
            case 'warning':
                PNotify.notice(wrapper);
                break;
            case 'error':
                PNotify.error(wrapper);
                break;
            default:
                PNotify.notice(wrapper);
        }
    };

    this.popIn = function (msg) { // this.PUBLIC
        var wrapper = {
            text: msg.text ? msg.text : 'Pop In Notification Type',
            title: msg.title ? msg.title : 'Notification shown within the Browser',
            type: msg.type ? msg.type : 'error',
            desktop: false
        };
        sendNotification(wrapper);
    };

    this.popOut = function (msg) { // this.PUBLIC
        var wrapper = {
            'text': msg.text ? msg.text : 'Pop Out Notification Type',
            'title': msg.title ? msg.title : 'Notification shown outside the Browser',
            type: msg.type ? msg.type : 'error',
            desktop: true
        };
        sendNotification(wrapper);


        //    	new PNotify({
        //            title: 'Desktop Notice',
        //            text: 'If you\'ve given me permission, I\'ll appear as a desktop notification. If you haven\'t, I\'ll still appear as a regular PNotify notice.',
        //            desktop: {
        //                desktop: true
        //            },
        //            nonblock: {
        //                nonblock: true
        //            }
        //        });


        //     	(new PNotify({
        //     	    title: 'Desktop Success',
        //     	    text: 'If you\'ve given me permission, I\'ll appear as a desktop notification. If you haven\'t, I\'ll still appear as a regular PNotify notice.',
        //     	    type: 'success',
        //     	    desktop: {
        //     	        desktop: true
        //     	    }
        //     	})).get();
        //     	.click(function(e) {
        //     	    if ($('.ui-pnotify-closer, .ui-pnotify-sticker, .ui-pnotify-closer *, .ui-pnotify-sticker *').is(e.target)) return;
        //     	    alert('Hey! You clicked the desktop notification!');
        //     	});


    };

    this.popHide = function () {
        PNotify.closeAll();
    };

    this.popTest = function () {
        this.popIn(getDebugMsg());
    };

    this.popSpam = function () {
        PNotify.modules.History.showAll();
    };

    //    document.addEventListener('DOMContentLoaded', function () {
    //    	if (Notification.permission !== "granted")
    //    		Notification.requestPermission();
    //    });

    this.popAuth = function () {
        try {
            if (Notification.permission !== "granted") {
                Notification.requestPermission();
            }
        } catch (e) {
            console.log("Notification Permissions Auth Problem " + e);
        }

    };

};
