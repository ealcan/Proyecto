import { FC, useEffect } from 'react'

type WinsProps = {
  id: number,
  name: string;
  description: string;
  rewardsPoints: number;
  difficulty: string;
  image: string;
}

const username = "user2";
var idUser: number;


const showToastOk = (message: string) => {
  M.toast({html: `<i class="material-icons left">check</i><span>${message}</span>`, 
  displayLength: 2500,
  inDuration: 500,
  outDuration: 500,
  classes: 'alert-ok '});
};

const Wins: FC<WinsProps> = ({id, name, description, rewardsPoints, difficulty, image }) => {

  useEffect(() => {
    const fetchUserData = async () => {
        try {
            const response = await fetch(`http://localhost:8080/users/find/${username}`);
            if (!response.ok) {
                throw new Error('Failed to fetch user data');
            }
            const data = await response.json();
            idUser = data.id;
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

    fetch(`http://localhost:8080/users/${idUser}/assign-win/${id}`, requestOptions)
    .then((response) => response.text(),)
    .then((result) => console.log(result))
    .catch((error) => console.error('Error:', error)), alert("ERROR");


    // showToastOk('¡Felicidades! Has empezado un objetivo')
    alert('¡Felicidades! Has empezado un objetivo')
        
    
};



  return (
    <div className="col s12 m4 row center">
      <div className="card card2" style={{ paddingRight: "10px", marginLeft: "-10px", marginRight: "10px", width: "390px", height: "600px", borderRadius: '15px', float: 'left', backgroundImage: `url(${image})`, backgroundSize: 'cover', backgroundPosition: 'center' }}>
        <div className="card-image waves-effect waves-block waves-light" style={{ borderTopLeftRadius: '15px', borderTopRightRadius: '15px' }}>
        </div>
        <div className="card-content">
          <div style={{ height: "550px" }}>
            <span className="card-title activator white-text text-darken-4" style={{ height: "100%", textShadow: '2px 2px 4px rgba(1, 1, 1, 1)' }}>{name}<i className="material-icons right"></i></span>
          </div>
          <div className="right #78909c blue-grey lighten-1" style={{ display: "flex", marginTop: "-12px", marginRight: "35%", justifyContent: "center", alignItems: "center", borderRadius: "3px", textShadow: '1px 1px 1px rgba(0.5, 0.5, 0.5, 0.5)', width: "89px", height: "38px", color: "white" }}>
            <p style={{ backgroundColor: "#78909c blue-grey lighten-1", color: "white", marginTop: "4px" }}>{rewardsPoints} points</p>
          </div>
          <button onClick={handleButtonClick} className="waves-effect waves-light btn-small" style={{ display: "flex", marginTop: "-12.6px", marginLeft: "22%", justifyContent: "center", alignItems: "center", height: "38px", width: "50px" }}><i className="material-icons">check</i></button>
        </div>
        <div className="card-reveal">
          <span className="card-title grey-text text-darken-4">{name}<i className="material-icons right">close</i></span>
          <p>{description}</p>
          <div style={{ color: "white", marginLeft: "-25px", borderTopRightRadius: '15px', borderBottomRightRadius: '15px', backgroundColor: "#ef9a9a", height: "100px", border: "1px solid #ccc", width: "30px", writingMode: "vertical-lr", textOrientation: "upright" }}>{difficulty}</div>
        </div>
      </div>
    </div>
  )
}

export default Wins;
