import { useState, useEffect } from 'react'
import { getTodos } from '../api/index.js'

const GetTodos = () => {
    const [todos, setTodos] = useState([])
    useEffect(() => {
        async function setTodo() {
            setTodos(await getTodos())
        }
        setTodo()
    }, [])
    return (
        <div>
            <ul>
                {todos.map(todos =>
                    <div key={todos.id}>
                        <li >{todos.task}</li>
                        <li>{todos.created}</li>
                    </div>
                )}
            </ul>
        </div>
    )
}

export default GetTodos