import { useState, useEffect } from 'react'
import { getTodos, deleteTodo, putTodo } from '../api/index.js'
import '../scss/custom.scss'
import { Button, Accordion, Stack, Form, ListGroup } from 'react-bootstrap'

const GetTodos = () => {
    const [todos, setTodos] = useState([])
    const [edit, setEdit] = useState([])
    useEffect(() => {
        async function setTodo() {
            setTodos(await getTodos())
        }
        setTodo()
    }, [])
    return (
        todos.map(todos =>
            <div key={todos.id}>
                <Stack className='mx-auto d-flex justify-content-center w-75 mt-3' direction='horizontal' gap={1} >
                    <div className='w-50'>
                        <ListGroup className='group-list-primary w-100 border'>
                            <ListGroup.Item className='group-list-item list-group-item-primary display-6'>{todos.task}</ListGroup.Item>
                            <ListGroup.Item className='group-list-item list-group-item-secondary'>{`Criado dia ${todos.created.slice(5, 7)}/${todos.created.slice(8, 10)} as ${todos.created.slice(11, 16)} horas`}</ListGroup.Item>
                        </ListGroup>
                    </div>
                    <div>
                        <Form>
                            <Button className='btn-danger' type='submit' onClick={() => {
                                deleteTodo(todos.id)
                                window.location.reload(false)
                            }}>Deletar</Button>
                        </Form>
                    </div>
                    <div>
                        <Accordion defaultActiveKey={0}>
                            <Accordion.Item>
                                <Accordion.Header>Editar</Accordion.Header>
                                <Accordion.Body>
                                    <Form className='me-auto'>
                                        <input placeholder='Nova tarefa' className='form-control' type="text" onChange={(e) => setEdit(e.target.value)} />
                                        <Button className='btn-primary' onClickCapture={() => {
                                            window.location.reload(false)
                                            putTodo(todos.id, edit)
                                        }}>Editar</Button>
                                    </Form>
                                </Accordion.Body>
                            </Accordion.Item>
                        </Accordion>
                    </div>
                </Stack>
            </div >
        )
    )
}

export default GetTodos