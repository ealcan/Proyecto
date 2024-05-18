import { FC } from 'react'
import {useState, useEffect } from 'react'; 
import "../../styles/RewardsStyle.css"
import Fondo from "../../assets/Montañas.jpg"

type MiComponenteProps = {
    id: number;
    mensaje: string;
    titulo: string;
    precio: number;
    imagen: string;
  }


const username = "user2";
var idUser: number;
var points: number;

const showToastError = (message: string) => {
    M.toast({html:`<i class="material-icons left">close</i><span>${message}</span>`, 
    displayLength: 2500,
    inDuration: 500,
    outDuration: 500,
    classes: 'alert-error',});
};

const showToastOk = (message: string) => {
    M.toast({html: `<i class="material-icons left">check</i><span>${message}</span>`, 
    displayLength: 2500,
    inDuration: 500,
    outDuration: 500,
    classes: 'alert-ok '});
};


const Rewards2: FC<MiComponenteProps> = ({id, mensaje, titulo, precio, imagen,}) => {
    

    useEffect(() => {
        const fetchUserData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/users/find/${username}`);
                if (!response.ok) {
                    throw new Error('Failed to fetch user data');
                }
                const data = await response.json();
                idUser = data.id;
                points = data.points;
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };

        fetchUserData();
    }, []);

    const handleButtonClick = async  () => {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const requestOptions: RequestInit = {
        method: "POST",
        headers: myHeaders,
        redirect: "follow" as RequestRedirect, 
        };
    
        fetch(`http://localhost:8080/users/${idUser}/assign-reward/${id}`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error('Error:', error));
        

        if (points < precio) {
            // showToastError('No tienes puntos suficientes ¡Sigue trabajando!')
            alert('No tienes puntos suficientes ¡Sigue trabajando!')
        }
        else{
            // showToastOk('¡Felicidades! Has reclamado tu premio!')
            alert('¡Felicidades! Has reclamado tu premio!')
        }
    };

    const [hovered, setHovered] = useState(false);
    
    
    return (

   
        <>
            <div className="col s12 m4 row center" style={{marginTop:"100px", display: "flex"}}>
                <div className="card " style={{ borderRadius: '15px', position: "relative", width:"300px",margin: "auto"}}>          
                    <div className="card-image">
                        <img src={Fondo} alt="Logo" style={{ borderTopLeftRadius: '15px',
                            borderTopRightRadius: '15px',
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            border: '1px solid #ccc',
                            transition: 'height 0.3s ease',
                            height: hovered ? '380px' : '350px',
                        }}
                        onMouseEnter={() => setHovered(true)}
                        onMouseLeave={() => setHovered(false)} className="imagen-logo-AWSNT"/>
                        
                        <span className="card-title" style={{ textShadow: '2px 2px 4px rgba(1, 1, 1, 1)' }}>{titulo}</span>      
                        <button onClick={handleButtonClick} className="waves-effect  btn-small #263238 blue-grey darken-4 right">Canjear</button>
                    </div>
                    <div className="right #78909c blue-grey lighten-1" style={{borderRadius:"3px", right: "0px", position:"absolute", textShadow: '1px 1px 1px rgba(0.5, 0.5, 0.5, 0.5)', marginTop: '-28px', width: "89px", height: "28px",  color: "white"}}> 
                            <p style={{backgroundColor: "#78909c blue-grey lighten-1", color: "white",  marginTop: "4px" }}>{precio} points</p>
                        </div>
                    <div className="card-content" >
                        
                        <p style={{ width: "75%" ,textAlign: "center", marginLeft: "-10px"}}>{mensaje}{idUser}</p>
                    </div>
                </div>
            </div>
            
        </>
        
    )
}
export default Rewards2;
