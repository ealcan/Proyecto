import { FC } from 'react'
import { useState } from 'react'; 

type MiComponenteProps = {
    mensaje: string;
    titulo: string;
    precio: number;
    imagen: string;
  }

const Rewards: FC<MiComponenteProps> = ({ mensaje, titulo, precio, imagen,}) => {
    const [hovered, setHovered] = useState(false);
    return (
        <>
            <div className="col s12 m4">
                <div className="card" style={{ borderRadius: '15px', position: "relative"}}>          
                    <div className="card-image">
                        <img src={imagen} alt="Logo" style={{ borderTopLeftRadius: '15px',
                            borderTopRightRadius: '15px',
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            border: '1px solid #ccc',
                            transition: 'height 0.3s ease',
                            height: hovered ? '220px' : '200px',
                        }}
                        onMouseEnter={() => setHovered(true)}
                        onMouseLeave={() => setHovered(false)} className="imagen-logo-AWSNT"/>
                        
                        <span className="card-title" style={{ textShadow: '2px 2px 4px rgba(1, 1, 1, 1)' }}>{titulo}</span>      
                        <a className="waves-effect  btn-small #263238 blue-grey darken-4 right">Canjear</a>
                    </div>
                    <div className="right #78909c blue-grey lighten-1" style={{borderRadius:"3px", right: "0px", position:"absolute", textShadow: '1px 1px 1px rgba(0.5, 0.5, 0.5, 0.5)', marginTop: '-28px', width: "89px", height: "28px",  color: "white"}}> 
                            <p style={{backgroundColor: "#78909c blue-grey lighten-1", color: "white",  marginTop: "4px" }}>{precio} points</p>
                        </div>
                    <div className="card-content" >
                        <p style={{ width: "75%" ,textAlign: "center", marginLeft: "-10px"}}>{mensaje}</p>
                        
                    </div>
                    
                </div>
            </div>
        </>
        
    )
}
export default Rewards;
