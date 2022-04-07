import axios from 'axios'

const url = 'http://localhost:8090/api/v1/todo'
export const getTodos = async () => {
    let data;
    await axios.get(url).then((res) => { data = res.data })
    return data
}
export const postTodo = async (todo) => {
    await axios.post(url, { "task": todo })
}
export const deleteTodo = async (id) => {
    await axios.delete((url + `/${id}`))
}
export const putTodo = async (id, newTask) => {
    await axios.put((url + `/${id}`), { task: newTask })
}