import { useEffect, useState } from "react";
import axios from 'axios'
export default function App() {
  const [todos, settodos] = useState()

  useEffect(() => {
    const a = async () => await axios.get('http://localhost:8090/api/v1/todo').then((res) => {
      settodos(res.data[0])
    })
    a()
  }, []
  )


  return (
    <div className="App">
      <p>{todos?.task}</p>
      <p>{todos?.created}</p>
    </div>
  );
}