import InProcessWins from "./InProcessWins";
import CompletedWins from "./CompletedWins";

const SectionWins2 = () => {
  return (
    <div className="container">
      <div style={{ marginBottom: "-140px", height: "150px" }}></div>
      <div style={{ marginBottom: "-130px", height: "150px" }}></div>

      <div style={{marginTop:"50px", textAlign: "center", marginBottom: "50px" }}>
        <h2 className="letraWins2">TUS OBJETIVOS</h2>
        <h4 className="letraWins2">Consulta aquí el estado de tus objetivos</h4>
      </div>

      <div style={{ display: "flex" , marginBottom: "50px"}}>
        <div style={{ width: "50%" }}>
          <p className="row center letraWins #eceff1 blue-grey lighten-5" style={{ paddingTop: "10px", borderRight: "1px solid #ccc", marginBottom: "-10px", height: "60px", borderTopLeftRadius: "15px" }}>COMPLETADOS</p>
          <CompletedWins />
        </div> 
        <div style={{ width: "50%" }}>
          <p className="row center letraWins #eceff1 blue-grey lighten-5" style={{ paddingTop: "10px", borderLeft: "1px solid #ccc", marginBottom: "-10px", height: "60px", borderTopRightRadius: "15px" }}>EN PROCESO</p>
          <InProcessWins />
        </div>
      </div>
    </div>
  );
}

export default SectionWins2;

