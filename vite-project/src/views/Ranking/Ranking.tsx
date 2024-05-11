import Nav from "../../components/layout/Nav"
import cartaimg from "../../assets/cartaimg.jpg"
function Ranking() {
    return (
      <div>
      <Nav /> 
      <div className="card">
        <div className="card-image waves-effect waves-block waves-light">
          <img className="activator" src="images/office.jpg" alt="Office" />
        </div>
        <div className="card-content">
          <span className="card-title activator grey-text text-darken-4">Ranking2<i className="material-icons right">more_vert</i></span>
          <p><a href="#">This is a link</a></p>
          <div className="image-container">
            <img src={cartaimg} alt="Unsplashed background cartaimg" />
          </div>
          <div className="optionList">
            {/* Aquí puedes agregar tus iconos u otros elementos */}
            <img src="favorite" alt="Favorite" />
            {/* Asegúrate de corregir la sintaxis de 'favorite' y otros iconos según lo necesario */}
          </div>
        </div>
        <div className="card-reveal">
          <span className="card-title grey-text text-darken-4">ranking1<i className="material-icons right">close</i></span>
          <div className="image-container">
            <img src={cartaimg} alt="Unsplashed background cartaimg" />
          </div>
          <div className="optionList">
            <img src="favorite" alt="Favorite" />
          </div>
          <p>Here is some more information about this product that is only revealed once clicked on.</p>
        </div>
      </div>
    </div>
    );
  }
  
  export default Ranking;
