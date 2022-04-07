import { postTodo } from "../api/index.js"
import { useState } from "react"
import { Button, Form, } from 'react-bootstrap'
const PostTodos = () => {
    const [todo, setTodo] = useState([])
    return (
        <div className="d-flex justify-content-center">
            <Form>
                <p className="form-label display-6">Adicionar nova tarefa</p>
                <input placeholder="Nova tarefa" className="form-control" type="text" id="todo" onChange={(e) => {
                    setTodo(e.target.value)
                }}></input>
                <Button className="btn-primary" type="submit" onClick={() => {
                    postTodo(todo)
                    window.location.reload(false)
                }}>
                    Adicionar
                </Button>
            </Form>
        </div >
    )
}

export default PostTodos