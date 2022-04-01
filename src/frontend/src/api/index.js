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