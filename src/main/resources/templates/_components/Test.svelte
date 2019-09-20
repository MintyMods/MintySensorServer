<script>
    let lastId = 0;
    const createTodo = (text, done = false) => ({
        id: ++lastId,
        text,
        done
    });

    let todoText = '';
    let todos = [
        createTodo('learn', true);
        createTodo('create')
    ];

    $: uncompletedCount = todos.filter(t => !t.done).length;
    $: status = `${uncompletedCount} of ${todos.length} remaining`;

    function addTodo() {
        todos = todos.concat(createTodo(todoText));
        todoText = '';
    }

    const archiveCompleted = () => todos = todos.filter(t => !t.done);
    const deleteTodo = todoId => todos = todos.filter(t => t.id !== todoId);

    function toggleDone(todo) {
        const {
            id
        } = todo;
        todos = todos.map(t => t.id === id ? {
            ...t,
            done: !t.done
        } : t);
    }

    $: average = total / count;
    $: console.log('count =', count);

    $: {
        // statements to repeat go here
    }

    $: if (anyVarChangeToTriggerBody) {
        // Body to trigger
    }

</script>
