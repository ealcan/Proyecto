import {FC} from "react";
import SectionRewards from '../../components/layout/SectionRewards';
import HeadRewards from '../../components/layout/HeadRewards';
import SectionRewards2 from "../../components/layout/SectionRewards2";

  
const rewards: FC = () => {

    return (

      <>
        <body >
          <HeadRewards />
          <SectionRewards />
          <div style={{ marginBottom: "-140px", height: "150px" }}></div>
            <div style={{ marginBottom: "-130px", height: "150px" }}></div>

            <div style={{marginTop:"50px", textAlign: "center", marginBottom: "80px"}}>
              <h2 className="letraWins2">TUS RECOMPENSAS</h2>
              <h4 className="letraWins2">Consulta aquí el estado de tus recompensas</h4>
            </div>
          <div className="row center" style={{width: "50%"}}>
          <p className="row center letraWins #eceff1 blue-grey lighten-5" style={{ paddingTop: "10px", borderRight: "1px solid #ccc", marginBottom: "-10px", height: "60px", borderTopLeftRadius: "15px", borderTopRightRadius: "15px" }}>RECLAMADAS</p>
          <SectionRewards2 />
          </div>
        </body>
    </>
  )
}

export default rewards