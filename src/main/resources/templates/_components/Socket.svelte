
<script>
    import {
        onMount
    } from 'svelte';

            var stompClient = null;
        var username = null;

    
    onMount(() => {


        function connect(event) {
            var socket = new SockJS('https://localhost:8080/ws');
            stompClient = Stomp.over(socket);

            stompClient.connect({}, onConnected, onError);
            event.preventDefault();
        }


        function onConnected() {
            stompClient.subscribe('/api', onMessageReceived);
            stompClient.send("/app/chat.addUser", {},
                JSON.stringify({
                    sender: username,
                    type: 'JOIN'
                })
            )

        }

        function subscribe() {
            var channel = channelInput.value.trim()
            stompClient.subscribe(channel, onMessageReceived);
        }

        function onError(error) {
            connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
            connectingElement.style.color = 'red';
        }


        function sendMessage(event) {
            var messageContent = messageInput.value.trim();
            if (messageContent && stompClient) {
                var chatMessage = {
                    sender: username,
                    content: messageInput.value,
                    type: 'CHAT'
                };
                stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
            }
            event.preventDefault();
        }


        function onMessageReceived(payload) {
            var message = JSON.parse(payload.body);

        }


    });

</script>
