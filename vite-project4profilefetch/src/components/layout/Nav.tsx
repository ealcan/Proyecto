import { FC } from "react"
import '../../App.css'
import LogoAWSNT from '../../assets/Logo AWSNT - Sin.png'

const Nav: FC = () => {
  return (
    <>
      {/* Dropdown Structure */}
      <ul id="dropdown1" className="dropdown-content">
        <li><a href="#!">Castellano</a></li>
        <li className="divider"></li>
        <li><a href="#!">Catalán</a></li>
        <li className="divider"></li>
        <li><a href="#!">Inglés</a></li>
      </ul><nav>
        <div className="nav-wrapper colorbase">
          <a href="#!" className="brand-logo">
            <img src={LogoAWSNT} alt="Logo" className="logo-AWSNT-cabecera" />
          </a>
          <ul className="right hide-on-med-and-down">
            <li><a href="sass.html">Presentación</a></li>
            <li><a href="badges.html">Conócenos</a></li>
            <li><a href="sass.html">Únete</a></li>
            {/* Dropdown Trigger */}
            <li><a className="dropdown-trigger" href="#!" data-target="dropdown1">Idioma<i className="material-icons right">arrow_drop_down</i></a></li>
          </ul>
          {/* Responsive para mobile*/}
          <ul id="nav-mobile" className="sidenav">
            <li><a href="#">Navbar Link</a></li>
            <li><a href="idioma.html">Idioma</a></li>
            <li><a href="sass.html">Sass</a></li>
            <li><a href="badges.html">Components</a></li>
          </ul>
          <a href="#" data-target="nav-mobile" className="sidenav-trigger">
            <i className="material-icons">menu</i>
          </a>
        </div>
      </nav></>
  );
}

export default Nav;
