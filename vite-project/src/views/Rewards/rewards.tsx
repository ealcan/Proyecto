import Nav from '../../components/layout/Nav';
import Rewards from "../../components/layout/Rewards";
import Paisaje from '../../assets/Paisaje.jpg'
import Gorra from '../../assets/Gorra.jpg'

const rewards = () => {
  return (
    <>
    <header>
        <Nav />
    </header>
    <body >
    <div className="container">
            <br /><br />
            <h3 className="header col s12 light deep-orange-text text-lighten-2 letraGrosor center">Recompensas</h3>
            <br /><br />
            <div className="row center">
                <div>
                    <Rewards titulo ="Viaje" mensaje = "Hola mundo" precio = {10000} imagen = {Paisaje}/>
                    <Rewards titulo ="Gorra" mensaje = "Hola mundo" precio = {150} />
                    <Rewards titulo ="Mochila" mensaje = "Hola mundo" precio = {310}/>
                </div>
            </div>
            <div className="row center">
                <div>
                    <Rewards titulo ="Camiseta" mensaje = "Hola mundo" precio = {250}/>
                    <Rewards titulo ="Retiro" mensaje = "Hola mundo" precio = {7500}/>
                    <Rewards titulo ="Curso" mensaje = "Hola mundo" precio = {1900}/>
                </div>
            </div>
        </div>
    </body>
    
    </>
  )
}

export default rewards