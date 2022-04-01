import { postTodo } from "../api/index.js"
import { useState } from "react"
const PostTodos = () => {
    const [todo, setTodo] = useState([])
    const handleSubmit = (e) => {
        e.preventDefault()
    }
    return (
        <div>
            <form>
                <h1>Type new todo</h1>
                <input type="text" id="todo"></input>
                <button onClick={handleSubmit()}>
                    send
                </button>
            </form>
        </div >
    )
}

export default PostTodos