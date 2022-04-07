
import GetTodos from './components/getTodos.js'
import PostTodos from './components/postTodos.js'
import NavBar from './components/navbar.js'
import './scss/custom.scss'
export default function App() {
  return (
    <>
      <NavBar />
      <GetTodos />
      <PostTodos />
    </>
  );
}