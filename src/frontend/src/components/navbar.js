import '../scss/custom.scss'
import { Navbar } from 'react-bootstrap'

const NavBar = () => {
    return (
        <Navbar className='navbar navbar-light bg-primary text-black justify-content-center'>
            <p className='display-4'>Lista de tarefas :)</p>
        </Navbar>
    )
}
export default NavBar