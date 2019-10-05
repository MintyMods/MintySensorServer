<svelte:head>
    <title>Testing</title>
</svelte:head>
<script>
  import Notification from "../_components/Notification.svelte";
    import {
        storeSelectedThemeColor
    } from '../_stores/main-state.js';


    function getRandomColor() {
        var letters = '0123456789ABCDEF'.split('');
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
    let themeColor;

    const unsubscribe = storeSelectedThemeColor.subscribe(value => {
        themeColor = value;
    });

    function changeTheme() {
        themeColor = getRandomColor();
        update("nav-wrapper", "background-color", themeColor);
        update("secondary-content>.material-icons", "color", themeColor);
        update("btn", "background-color", themeColor);
        update("page-footer", "background-color", themeColor);
        update("input-field", "color", themeColor);
        update("input-field>.material-icons", "color", themeColor);
        update("input-field>label", "color", themeColor);
        update("btn-floating", "background-color", themeColor);
        update("logo", "color", themeColor);
        update("active", "background-color", themeColor);
        //        update("dropdown-content>li>a", "color", themeColor);
    }

    function update(name, attrib, theme) {
        var elems = document.getElementsByClassName(name);
        if (elems.length > 0) {
            for (let elem of elems) {
                elem.setAttribute("style", attrib + ":" + theme + " !important");
            };
        }
    }

</script>


<button on:click={changeTheme}>Change Theme</button>
<h1>testing</h1>

<div class="row">
    <div class="col s12 m6">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title">Card Title</span>
                <p>I am a very simple card. I am good at containing small bits of information.
                    I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
                <a href="#!">This is a link</a>
                <a href="#!">This is a link</a>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col s12 m6">
        <div class="card">
            <div class="card-image">
                <img src="images/sample-1.jpg" alt="alt">
                <span class="card-title">Card Title</span>
                <a href="#!" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
            </div>
            <div class="card-content">
                <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
            </div>
        </div>
    </div>
</div>

<div class="card">
    <div class="card-content">
        <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
    </div>
    <div class="card-tabs">
        <ul class="tabs tabs-fixed-width">
            <li class="tab"><a href="#test4">Test 1</a></li>
            <li class="tab"><a class="active" href="#test5">Test 2</a></li>
            <li class="tab"><a href="#test6">Test 3</a></li>
        </ul>
    </div>
    <div class="card-content grey lighten-4">
        <div id="test4">Test 1</div>
        <div id="test5">Test 2</div>
        <div id="test6">Test 3</div>
    </div>
</div>
