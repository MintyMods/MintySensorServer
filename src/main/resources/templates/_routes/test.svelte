<svelte:head>
    <title>Testing</title>
</svelte:head>

<div id="username-page">
        <div class="username-page-container">
            <h1 class="title">Type your username</h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="accent username-submit">Start Chatting</button>
                </div>
            </form>
        </div>
    </div>

    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Spring WebSocket Chat Demo</h2>
            </div>
            <div class="connecting">
                Connecting...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Send</button>
                        <input type="text" id="channel" placeholder="Type a channel" autocomplete="off" class="form-control"/>
                        <button type="button" id="channelbtn" class="primary">Subscribe</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<!--
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
-->
    
<script>

//var stompClient = null;
//
//function setConnected(connected) {
// $("#connect").prop("disabled", connected);
// $("#disconnect").prop("disabled", !connected);
// if (connected) {
// $("#conversation").show();
// }
// else {
// $("#conversation").hide();
// }
// $("#greetings").html("");
//}
//
//function connect() {
// var socket = new SockJS('/gs-guide-websocket');
// stompClient = Stomp.over(socket);
// stompClient.connect({}, function (frame) {
// setConnected(true);
// console.log('Connected: ' + frame);
// stompClient.subscribe('/topic/greetings', function (greeting) {
// showGreeting(JSON.parse(greeting.body).content);
// });
// });
//}
//
//function disconnect() {
// if (stompClient !== null) {
// stompClient.disconnect();
// }
// setConnected(false);
// console.log("Disconnected");
//}
//
//function sendName() {
// stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
//}
//
//function showGreeting(message) {
// $("#greetings").append("<tr>
// <td>" + message + "</td>
//</tr>");
//}
//
//$(function () {
// $("form").on('submit', function (e) {
// e.preventDefault();
// });
// $( "#connect" ).click(function() { connect(); });
// $( "#disconnect" ).click(function() { disconnect(); });
// $( "#send" ).click(function() { sendName(); });
//});

</script>


