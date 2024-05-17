import { FC } from "react"

const Header: FC = () => {
  return (
    <nav>
      <div> 
        <h1>Header</h1>
        <a>LOGO</a>
        <ul>
          <li><a href="#">Navbar Link MOBILE</a></li>
        </ul>
        <a><i>menu para MOBILE</i></a>
      </div>
    </nav>
  )
}

export default Header