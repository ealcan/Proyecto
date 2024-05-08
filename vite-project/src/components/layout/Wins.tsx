import Paisaje from '../../assets/Paisaje.jpg'
import "../../styles/WinsStyle.css"

function Wins() {
  return (
    <>
    <div className="card" style={{ marginTop: "20px"}}>
    <p className="colorTexto">dfsafas</p>
    <div className="card-image waves-effect waves-block waves-light">
    
    <img src={Paisaje} alt="Paisaje" className="imagen-paisaje-AWSNT"/>
   
    </div>
    <div className="card-content">
      <span className="card-title activator grey-text text-darken-4">Card Title<i className="material-icons right">more_vert</i></span>
      <p><a className="#">This is a link</a></p>
    </div>
    <div className="card-reveal">
      <span className="card-title grey-text text-darken-4">Card Title<i className="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
  </div>
  </>
  )
}

export default Wins